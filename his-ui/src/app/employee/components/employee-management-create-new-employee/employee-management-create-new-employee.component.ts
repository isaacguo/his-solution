import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnDestroy,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {AbstractCreateUpdateComponent} from "../../../shared/components/abstract-create-update-component/abstract-create-update.component";
import {EmploymentStatusEnum} from "../../../core/enums/employment-status.enum";
import {SexualEnum} from "../../../core/enums/sexual.enum";
import {GenderEnum} from "../../../core/enums/gender.enum";
import {Observable} from "rxjs/Observable";
import {Subscription} from "rxjs/Subscription";


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
  selector: 'app-employee-management-create-new-employee',
  templateUrl: './employee-management-create-new-employee.component.html',
  styleUrls: ['./employee-management-create-new-employee.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementCreateNewEmployeeComponent extends AbstractCreateUpdateComponent implements OnInit, OnChanges, OnDestroy {


  changeLoginAccountModel: FormGroup;

  passwordFormModel: FormGroup;

  formModel: FormGroup;

  @Input()
  departmentId: number;
  @Input()
  employee: any;
  @Input()
  employeeCreatedObservable: Observable<any>;

  @Input()
  employeeUpdatedObservable: Observable<any>;

  @Output()
  employeeCreated = new EventEmitter<any>();
  @Output()
  employeeUpdated = new EventEmitter<any>();
  @Output()
  passwordChanged = new EventEmitter<any>();

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
  ) {
    super(route);

  }

  invokeWhenCreate() {
    this.employeeCreated.emit(this.formModel.value);
  }

  invokeWhenUpdate() {
    this.employeeUpdated.emit(this.formModel.value);
  }


  ngOnInit() {
    this.getEmployeeStatusList();
    this.getSexualList();

    this.initForm();
    this.process();

    if (this.operation === OperationEnum.CREATE) {
      this.formModel.controls['departmentId'].setValue(this.departmentId);
    }
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
      'fullNameHanYuPinYin': [''],
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

  employeeStatusArr = [];

  getEmployeeStatusList() {

    this.employeeStatusArr = Object.keys(EmploymentStatusEnum).map(k => {
      return [k, EmploymentStatusEnum[k as any]]
    });

  }

  selectedStatusText: string = "";

  onStatusClicked(status: string) {
    this.selectedStatusText = EmploymentStatusEnum[status];
    this.formModel.controls['employmentStatus'].setValue(status);
  }

  sexualArr = [];

  getSexualList() {
    this.sexualArr = Object.keys(SexualEnum).map(k => {
      return [k, SexualEnum[k as any]]
    });

  }

  selectedGenderText: string = "";

  onSexualClicked(gender: string) {
    this.selectedGenderText = SexualEnum[gender];
    this.formModel.controls['gender'].setValue(gender);
  }

  onChangePasswordModalClosed() {
    this.passwordChanged.emit({id:this.passwordFormModel.controls['id'].value,password:this.passwordFormModel.get('passwordsGroup').get('password').value});
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
    /*
    this.employeeService.updateEmployeeLoginAccount(this.changeLoginAccountModel.value).subscribe(r => {
      this.loadData();
    })
    */
  }

  onGetHanYuPinYinButtonClicked() {
  }

  employeeCreatedSubscription: Subscription;
  employeeUpdatedSubscription: Subscription;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['employeeCreatedObservable'] && this.employeeCreatedObservable) {
      this.employeeCreatedSubscription = this.employeeCreatedObservable.subscribe(() => {
        this.confirmCreateModal.open();
      })
    }

    if (changes['employeeUpdatedObservable'] && this.employeeUpdatedObservable) {
      this.employeeUpdatedSubscription = this.employeeUpdatedObservable.subscribe(() => {
        this.confirmCreateModal.open();
      })
    }


    if (changes['employee'] && this.employee && this.operation === OperationEnum.UPDATE) {
      this.inflateFormModelWithValues(this.employee);
    }

  }

  ngOnDestroy(): void {
    this.employeeCreatedSubscription.unsubscribe();
    this.employeeUpdatedSubscription.unsubscribe();
  }


  onConfirmCreateModalClosed() {
    this.router.navigate(['departments', this.departmentId], {relativeTo: this.route.parent})

  }
}
