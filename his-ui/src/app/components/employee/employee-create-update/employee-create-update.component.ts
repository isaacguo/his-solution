import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router, RoutesRecognized} from "@angular/router";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";
import {EmployeeService} from "../../../services/employee/employee.service";
import {OperationEnum} from "../../../enums/operation.enum";
import {EmploymentStatusEnum} from "../../../enums/employment.status.enum";
import {SexualEnum} from "../../../enums/sexual.enum";
import {GenderEnum} from "../../../enums/gender.enum";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Employee} from "../../../dto/employee/employee.model";

@Component({
  selector: 'app-employee-create-update',
  templateUrl: './employee-create-update.component.html',
  styleUrls: ['./employee-create-update.component.css']
})
export class EmployeeCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  employee:Employee;

  changeLoginAccountModel:FormGroup;

  passwordFormModel:FormGroup;

  formModel: FormGroup;

  @ViewChild("confirmCreateModal")
  confirmCreateModal: ModalComponent;
  @ViewChild("changePasswordModal")
  changePasswordModal:ModalComponent;
  @ViewChild("changeAccountModal")
  changeAccountModal:ModalComponent;
  @ViewChild("changeAccountWarningModal")
  changeAccountWarningModal:ModalComponent;


  constructor(private router: Router,
              public route: ActivatedRoute,
              private fb: FormBuilder,
              private employeeService: EmployeeService) {
    super(route);
  }

  invokeWhenCreate() {
    this.employeeService.createEmployee(this.formModel.value).subscribe(r => {
      this.confirmCreateModal.open();
    });
  }

  invokeWhenUpdate() {
    this.employeeService.updateEmployee(this.formModel.value).subscribe(r => {
      this.confirmCreateModal.open();
    });
  }

  onConfirmCreateModalClosed() {
    this.router.navigate(['employee-admin']);
  }

  ngOnInit() {
    this.initForm();
    this.process();

    if (this.operation === OperationEnum.CREATE) {
      this.route.params.subscribe(params => {
        this.updateId = params['updateId'];
      });

      this.formModel.controls['departmentId'].setValue(this.updateId);
    }
    else {

      this.employeeService.getEmployeeInfoByEmployeeUuid(this.updateId).subscribe(r => {
        this.employee=r;
        this.inflatFormModelWithValues(this.employee);
      });
    }
  }

  private inflatFormModelWithValues(r) {
    this.formModel.controls['departmentId'].setValue("0");
    this.formModel.controls['id'].setValue(r.id);
    this.formModel.controls['employeeNumber'].setValue(r.employeeNumber);
    this.formModel.controls['loginAccount'].setValue(r.loginAccount);
    this.formModel.controls['joinedDate'].setValue(r.joinedDate);
    this.formModel.controls['jobTitle'].setValue(r.jobTitle);
    this.formModel.controls['employmentStatus'].setValue(r.employmentStatus);
    this.selectedStatusText = EmploymentStatusEnum[r.employmentStatus];

    this.formModel.controls['surname'].setValue(r.surname);
    this.formModel.controls['givenName'].setValue(r.givenName);
    this.formModel.controls['fullName'].setValue(r.fullName);

    this.formModel.controls['idNumber'].setValue(r.idNumber);
    this.formModel.controls['driverLicenseNumber'].setValue(r.driverLicenseNumber);
    this.formModel.controls['dateOfBirth'].setValue(r.dateOfBirth);
    this.formModel.controls['gender'].setValue(r.gender);
    this.selectedGenderText = GenderEnum[r.gender];
    this.formModel.controls['nationality'].setValue(r.nationality);
    this.formModel.controls['ethnic'].setValue(r.ethnic);
    this.formModel.controls['email'].setValue(r.email);
  }

  private initForm() {
    this.changeLoginAccountModel=this.fb.group({
      'loginAccount': ['', [Validators.required, Validators.minLength(8),Validators.pattern(/^[a-z0-9]*$/)]],
    })
    this.passwordFormModel=this.fb.group({
      'password':['',Validators.required]
    });
    this.formModel = this.fb.group({
      'id': [''],
      'departmentId': ['', Validators.required],
      'employeeNumber': ['', Validators.required],
      'loginAccount': ['', [Validators.required, Validators.minLength(8),Validators.pattern(/^[a-z0-9]*$/)]],
      'joinedDate': [''],
      'jobTitle': [''],
      'employmentStatus': ['', Validators.required],
      'surname': ['', Validators.required],
      'givenName': ['', Validators.required],
      'fullName': [''],
      'idNumber': ['', Validators.required],
      'driverLicenseNumber': [''],
      'dateOfBirth': [''],
      'gender': ['', Validators.required],
      'nationality': [''],
      'ethnic': [''],
      'email': [],
    })
  }

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  onDateChanged(control: string, event: IMyDateModel) {
    if (event.formatted !== '') {
      this.formModel.controls[control].setValue(event.formatted);
    }
    else {
      this.formModel.controls[control].setValue("");
    }
  }


  getEmployeeStatusList(): [string, string][] {
    let arr: any;

    arr = Object.keys(EmploymentStatusEnum).map(k => {
      return [k, EmploymentStatusEnum[k as any]]
    });
    return arr;

  }

  selectedStatusText: string = "";

  onStatusClicked(status: string) {
    this.selectedStatusText = EmploymentStatusEnum[status];
    this.formModel.controls['employmentStatus'].setValue(status);
  }


  getSexualList(): [string, string][] {
    let arr: any;
    arr = Object.keys(SexualEnum).map(k => {
      return [k, SexualEnum[k as any]]
    });
    return arr;

  }

  selectedGenderText: string = "";

  onSexualClicked(gender: string) {
    this.selectedGenderText = SexualEnum[gender];
    this.formModel.controls['gender'].setValue(gender);
  }

  onChangePasswordModalClosed() {

  }

  onChangePasswordLinkClicked() {
    this.changePasswordModal.open();
  }

  onChangeAccountWarningModalClosed() {
    this.changeAccountModal.open();
  }

  onChangeLoginAccountButtonClicked() {
    this.changeAccountWarningModal.open();
  }

  onChangeAccountModalClosed() {


  }
}
