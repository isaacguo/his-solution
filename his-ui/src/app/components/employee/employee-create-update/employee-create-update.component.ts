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


/**
 * Returns `true` if all FormControls in the specified FormGroup have exactly
 * the same value. Otherwise returns `false`.
 */
function equalValidator({value}: FormGroup): { [key: string]: any } {
  const [first, ...rest] = Object.keys(value || {});
  const valid = rest.every(v => value[v] === value[first]);
  return valid ? null : {equal: true};
}


@Component({
  selector: 'app-employee-create-update',
  templateUrl: './employee-create-update.component.html',
  styleUrls: ['./employee-create-update.component.css']
})
export class EmployeeCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  employee: any;

  changeLoginAccountModel: FormGroup;

  passwordFormModel: FormGroup;

  formModel: FormGroup;

  @ViewChild("confirmCreateModal")
  confirmCreateModal: ModalComponent;
  @ViewChild("changePasswordModal")
  changePasswordModal: ModalComponent;
  @ViewChild("changeAccountModal")
  changeAccountModal: ModalComponent;
  @ViewChild("changeAccountWarningModal")
  changeAccountWarningModal: ModalComponent;


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
      this.loadData();
    }
  }

  private loadData() {
    this.employeeService.getEmployeeInfoByEmployeeUuid(this.updateId).subscribe(r => {
      this.employee = r;
      this.inflateFormModelWithValues(this.employee);
    });
  }

  private inflateFormModelWithValues(r) {
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
    this.formModel.controls['fullNameHanYuPinYin'].setValue(r.fullNameHanYuPinYin);

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
    this.changeLoginAccountModel = this.fb.group({
      'id': [''],
      'loginAccount': ['', [Validators.required, Validators.minLength(8), Validators.pattern(/^[a-z0-9]*$/)]],
    })
    this.passwordFormModel = this.fb.group({
      'id': [''],
      'passwordsGroup': this.fb.group({
        'password': ['', [Validators.minLength(8), Validators.pattern(/^[a-zA-Z0-9]*$/)]],
        'pconfirm': ['']
      }, {validator: equalValidator})
    });

    this.formModel = this.fb.group({
      'id': [''],
      'departmentId': ['', Validators.required],
      'employeeNumber': ['', Validators.required],
      'loginAccount': ['', [Validators.required, Validators.minLength(8), Validators.pattern(/^[a-z0-9]*$/)]],
      'joinedDate': [''],
      'jobTitle': [''],
      'employmentStatus': ['', Validators.required],
      'surname': ['', Validators.required],
      'givenName': ['', Validators.required],
      'fullName': [''],
      'fullNameHanYuPinYin':[''],
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

    this.employeeService.updatePassword({
      'id': this.passwordFormModel.controls['id'].value,
      'password': this.passwordFormModel.get('passwordsGroup').get('password').value
    }).subscribe(r => {
      this.loadData();
    });

    /*
      this.employeeService.updatePassword(this.passwordFormModel.value).subscribe(r=>{
        this.loadData();
      })
      */

  }

  onChangePasswordLinkClicked() {

    this.passwordFormModel.reset();
    this.passwordFormModel.controls['id'].setValue(this.employee.id);
    this.changePasswordModal.open();
  }

  onChangeAccountWarningModalClosed() {
    this.changeAccountModal.open();
  }

  onChangeLoginAccountButtonClicked() {

    this.changeLoginAccountModel.controls['id'].setValue(this.employee.id);
    this.changeAccountWarningModal.open();
  }

  onChangeAccountModalClosed() {
    this.employeeService.updateEmployeeLoginAccount(this.changeLoginAccountModel.value).subscribe(r => {
      this.loadData();
    })
  }

  onGetHanYuPinYinButtonClicked() {
    this.employeeService.getHanYuPinYin(this.formModel.controls['surname'].value+ this.formModel.controls['givenName'].value).subscribe(r=>{
      this.formModel.controls['fullNameHanYuPinYin'].setValue(r);
    })
  }
}
