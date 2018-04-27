import {Component, Input, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";
import {EmployeeService} from "../../../services/employee/employee.service";

@Component({
  selector: 'app-employee-create-update',
  templateUrl: './employee-create-update.component.html',
  styleUrls: ['./employee-create-update.component.css']
})
export class EmployeeCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @Input()
  departmentId: number;

  formModel: FormGroup;

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder,
              private employeeService: EmployeeService) {
    super(route);
  }

  invokeWhenCreate() {
    this.employeeService.createEmployee(this.formModel.value).subscribe(r => {
      console.log("OK");
    });


  }

  invokeWhenUpdate() {
  }

  ngOnInit() {
    this.initForm();
    this.process();
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'employeeNumber': ['', Validators.required],
      'loginAccount': ['', [Validators.required, Validators.minLength(8)]],
      'joinedDate': [''],
      'jobTitle': [''],
      'employmentStatus': ['', Validators.required],
      'surname': ['', Validators.required],
      'givenName': ['', Validators.required],
      'fullName': [''],

      'idNumber': ['', Validators.required],
      'driverLicenseNumber': [''],
      'dateOfBirth': [''],
      'gender': [''],
      'nationality': [''],
      'ethnic': [''],
      'email': [],
    })
  }

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };

  onJoinedDateChanged($event: IMyDateModel) {

  }

  onDateOfBirthChanged($event: IMyDateModel) {

  }
}
