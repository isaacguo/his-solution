import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {EmployeeService} from "../../../core/services/employee/employee.service";

@Component({
  selector: 'app-employee-create-update-container',
  templateUrl: './employee-create-update-container.component.html',
  styleUrls: ['./employee-create-update-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class EmployeeCreateUpdateContainerComponent implements OnInit, OnDestroy {

  departmentId: Observable<number>;
  employeeCreatedObservable: Observable<any>;
  employeeUpdatedObservable: Observable<any>;

  employee: Observable<any>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeService: EmployeeService) {

    this.departmentId = this.route.params.map(p => p['departmentId']);
    this.employeeCreatedObservable = this.employeeService.employeeCreatedSubject.asObservable();
    this.employeeUpdatedObservable = this.employeeService.employeeUpdatedSubject.asObservable();

    this.employee = this.route.params.mergeMap((p) => {
      if (p['employeeUuid'])
        return this.employeeService.getEmployeeInfoByEmployeeUuid(p['employeeUuid'])
      else
        return Observable.of(null);
    });

  }

  ngOnInit() {
  }


  onEmployeeCreated(event) {
    this.employeeService.createEmployee(event);
  }

  ngOnDestroy(): void {
  }

  onEmployeeUpdated(event: any) {
    this.employeeService.updateEmployee(event);
  }

  onPasswordChanged(event: any) {
    this.employeeService.updatePassword(event);

  }
}
