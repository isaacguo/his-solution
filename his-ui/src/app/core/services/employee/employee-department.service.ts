import {Injectable, OnDestroy} from '@angular/core';
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../../shared/service-constants";
import {AuthHttp} from "angular2-jwt";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";
import {EmployeeDepartment} from "../../models/employee/employee-department.model";
import {EmployeeListItem} from "../../models/employee/employee-list-item.model";
import {EmployeeService} from "./employee.service";
import {Subscription} from "rxjs/Subscription";
import {DepartmentListItem} from "../../models/employee/department-list-item.model";

@Injectable()
export class EmployeeDepartmentService extends CrudService<EmployeeDepartment> implements OnDestroy {

  rootUrl: string = `${ServiceConstants.EMPLOYEE_URL}/departments`;

  rootDepartmentSubject = new BehaviorSubject<EmployeeDepartment | null>(null)
  managerSubject = new BehaviorSubject<EmployeeListItem>({}as EmployeeListItem);
  private getRootDepartmentUrl: string = `${this.rootUrl}/root`;

  private getDepartmentListUrl: string = "/api/hisemployee/departments/brief";

  managerChangedSubscription: Subscription;

  getDepartmentList(): Observable<DepartmentListItem[]> {
    return this.authHttp.get(this.getDepartmentListUrl).map(this.extractData);
  }

  constructor(authHttp: AuthHttp, employeeService: EmployeeService) {
    super(`${ServiceConstants.TREATMENT_URL}/departments`, authHttp);
    /*
    this.managerChangedSubscription = employeeService.getManagerChangedAsObservable().subscribe(() => {
      if (this.lastDepartmentId)
        this.findManager(this.lastDepartmentId);
    });
    */
  }

  ngOnDestroy(): void {
    this.managerChangedSubscription.unsubscribe();
  }

  getObservableRootDepartment(): Observable<EmployeeDepartment> {
    return this.rootDepartmentSubject.asObservable();
  }

  getRootDepartment() {
    this.authHttp.get(this.getRootDepartmentUrl).subscribe(res => {
      this.rootDepartmentSubject.next(res.json());
    });
  }

  getManagerAsObservable(): Observable<EmployeeListItem> {
    return this.managerSubject.asObservable();
  }

  lastDepartmentId: number;

  findManager(depId: number): Observable<EmployeeListItem> {
    this.lastDepartmentId = depId;
    let url = `${this.rootUrl}/find-manager/${this.lastDepartmentId}`;
    return this.authHttp.get(url).map(this.extractData).do(m => this.managerSubject.next(m));
  }

  createDepartment(parentId: number, name: string) {
    return this.authHttp.post(`${this.rootUrl}/create-department`, {
      'name': name,
      'parentId': parentId
    }).subscribe(() => this.getRootDepartment());
  }

  deleteDepartment(id: number) {
    return this.authHttp.delete(`${this.rootUrl}/delete-department/${id}`).subscribe(() => this.getRootDepartment());
  }


  getDepartmentById(id: number): Observable<EmployeeDepartment> {
    return this.authHttp.get(`${this.rootUrl}/${id}`).map(this.extractData);
  }

}
