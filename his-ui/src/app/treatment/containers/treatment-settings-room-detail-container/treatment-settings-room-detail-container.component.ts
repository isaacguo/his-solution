import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {Department} from "../../models/department.model";
import {Observable} from "rxjs/Observable";
import {TreatmentDepartmentService} from "../../../core/services/treatment/treatment-department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";
import {EmployeeService} from "../../../core/services/employee/employee.service";
import {TreatmentEmployeeService} from "../../../core/services/treatment/treatment-employee.service";
import {TreatmentEmployeeModel} from "../../models/treatment.employee.model";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {DepartmentOperationRequest} from "../../models/department.operation.request.model";
import {EmployeeDepartment} from "../../../core/models/employee/employee-department.model";
import {combineLatest} from "rxjs/observable/combineLatest";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-treatment-settings-room-detail-container',
  templateUrl: './treatment-settings-room-detail-container.component.html',
  styleUrls: ['./treatment-settings-room-detail-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentSettingsRoomDetailContainerComponent implements OnInit, OnDestroy {

  departmentInfoFromTreatmentSubject = new BehaviorSubject<Department>({} as Department);
  departmentInfoFromTreatmentObservable = this.departmentInfoFromTreatmentSubject.asObservable();

  employeeList: Observable<EmployeeListItem[]>;
  selectedEmployeeSubject = new BehaviorSubject<EmployeeListItem>({} as EmployeeListItem);
  selectedEmployee$ = this.selectedEmployeeSubject.asObservable();

  employeeInfoInTreatmentSubject = new BehaviorSubject<TreatmentEmployeeModel>({} as TreatmentEmployeeModel)
  employeeInfoInTreatment$: Observable<TreatmentEmployeeModel> = this.employeeInfoInTreatmentSubject.asObservable();


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService,
    private employeeDepartmentService: EmployeeDepartmentService,
    private treatmentDepartmentService: TreatmentDepartmentService,
    private treatmentEmployeeService: TreatmentEmployeeService) {
  }

  sub1:Subscription;
  ngOnInit() {

    this.route.params

      .mergeMap(params => this.employeeDepartmentService.getDepartmentById(params['departmentId']))
      .mergeMap(dep => this.treatmentDepartmentService.getDepartmentByDepId(dep.id, dep.name))
      .do(depInfo => {
        this.departmentInfoFromTreatmentSubject.next(depInfo)
      })
      .subscribe();

    this.employeeList = this.departmentInfoFromTreatmentObservable
      .mergeMap(d => {
        if (d.openToFrontDesk)
          return this.employeeService.getEmployeeListByDepartmentId(d.depId)
        else
          return Observable.of([])
      });


    this.sub1= this.selectedEmployee$
      .mergeMap(e => {
        if (e && e.id)
          return this.treatmentEmployeeService.findByEmpId(+e.id);
        else {
          return Observable.of({});
        }
      })
      .subscribe(data => this.employeeInfoInTreatmentSubject.next(data));
  }

  onDepartmentOpenChecked(event: DepartmentOperationRequest) {

    this.treatmentDepartmentService.setDepartmentOpenToFrontDeskValue(event)
      .mergeMap(() => this.treatmentDepartmentService.getDepartmentByDepId(event.depId, event.name))
      .do(() =>
        this.selectedEmployeeSubject.next({} as EmployeeListItem))
      .subscribe(d => this.departmentInfoFromTreatmentSubject.next(d));

    /*
  this.department.take(1).mergeMap()


  this.department.take(1).subscribe((d) => {
    this.treatmentDepartmentService.setDepartmentOpenToFrontDeskValue(d.depId, "", event);
  })
  */
  }

  onEmployeeSelected(event) {
    this.selectedEmployeeSubject.next(event);
    /*
    this.selectedEmployee$.take(1)
      .mergeMap(se => this.treatmentEmployeeService.findByEmpId(event.id))
      .subscribe(tes => this.employeeInfoInTreatmentSubject.next(tes));
      */
  }

  onListChanged() {
    this.selectedEmployeeSubject.next({} as EmployeeListItem);
    //this.treatmentEmployeeService.findByEmpId(0);
  }

  onEmployeeOpenChecked(event) {


    combineLatest(this.route.params, this.selectedEmployee$.take(1))
      .map(([params, employee]) => {
        return {
          canBeRegistered: event,
          loginAccount: employee.loginAccount,
          name: employee.fullName,
          empId: +employee.id,
          uuid: employee.uuid,
          departmentId: params['departmentId']
        }
      })
      .mergeMap((data) => this.treatmentEmployeeService.setCanBeRegisteredValue(data))
      .mergeMap(() => this.selectedEmployee$.take(1))
      .mergeMap(e => {
        return this.treatmentEmployeeService.findByEmpId(+e.id)
      })
      .subscribe(data => this.employeeInfoInTreatmentSubject.next(data));
  }


  ngOnDestroy(): void {
    this.sub1.unsubscribe();
  }


}
