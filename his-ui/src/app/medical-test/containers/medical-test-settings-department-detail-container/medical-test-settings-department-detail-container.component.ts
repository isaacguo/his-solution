import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Department} from "../../../treatment/models/department.model";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";
import {EmployeeService} from "../../../core/services/employee/employee.service";
import {MedicalTestDepartmentService} from "../../../core/services/medical-test/medical-test-department.service";
import {combineLatest} from "rxjs/observable/combineLatest";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-medical-test-settings-department-detail-container',
  templateUrl: './medical-test-settings-department-detail-container.component.html',
  styleUrls: ['./medical-test-settings-department-detail-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsDepartmentDetailContainerComponent implements OnInit {


  operationDoneSubject = new BehaviorSubject<boolean>(false);
  operationDone$ = this.operationDoneSubject.asObservable();

  department$: Observable<Department>;
  departmentInfoFromMedicalTest$: Observable<Department>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private employeeDepartmentService: EmployeeDepartmentService,
    private medicalTestDepartmentService: MedicalTestDepartmentService
  ) {


    this.department$ = combineLatest(this.route.params, this.operationDone$).mergeMap(([params, op]) => {

      return this.employeeDepartmentService.getDepartmentById(params['departmentId'])
    });

    this.departmentInfoFromMedicalTest$ = this.department$.mergeMap(dep => this.medicalTestDepartmentService.getDepartmentByDepId(dep.id, dep.name));


  }

  ngOnInit() {

  }

  onDepartmentOpenChecked($event) {
    this.department$.take(1).mergeMap(dep => this.medicalTestDepartmentService.setDepartmentEnable(dep.id, dep.name, $event))
      .subscribe(([]) => this.operationDoneSubject.next(true));
  }

}
