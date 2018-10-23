import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {ServiceConstants} from "../../../shared/service-constants";
import {EmployeeCount} from "../../models/employee/employee.count.model";
import {Employee} from "../../models/employee/employee.model";
import {EmployeeListItem} from "../../models/employee/employee-list-item.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Subject} from "rxjs/Subject";
import {CrudService} from "../crud.service";


@Injectable()
export class EmployeeService extends CrudService<Employee> {

  employeeListBehaviorSubject = new BehaviorSubject<EmployeeListItem[]>([]);
  lastQueriedDepartmentId: number;
  employeeCreatedSubject = new Subject<any>();
  employeeUpdatedSubject = new Subject<any>();

  rootUrl: string = `${ServiceConstants.EMPLOYEE_URL}/employees`;

  private deleteEmployeeUrl: string = `${this.rootUrl}/delete`;
  private createEmployeeUrl: string = `${this.rootUrl}/create`;
  private updateEmployeeUrl: string = `${this.rootUrl}/update`;
  private updateEmployeeLoginAccountUrl: string = `${this.rootUrl}/updateLoginAccount`;
  private updateEmployeePasswordUrl: string = `${this.rootUrl}/updatePassword`;
  private moveEmployeeToDepartmentUrl: string = `${this.rootUrl}/move-employee-to-department`;
  private setAsManagerUrl: string = `${this.rootUrl}/set-as-manager`;
  private getHanYuPinYinUrl: string = `${this.rootUrl}/getHanYuPinYin`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/employees`, authHttp);
  }

  private _showEmployeeView: boolean = false;

  get showEmployeeView(): boolean {
    return this._showEmployeeView;
  }

  set showEmployeeView(value: boolean) {
    this._showEmployeeView = value;
  }

  getEmployeeCount(): Observable<EmployeeCount> {
    let url = `/api/hisemployee/employees/counts`;
    return this.authHttp.get(url).map(this.extractData);
  }

  getEmployees(page: number, size: number) {
    super.loadPageData({page: page, size: size});
    /*
    let url = `${this.rootUrl}`;
    return this.authHttp.get(url)
      .map(this.extractData);
    */
  }

  findEmployeesByNameContains(keyword: string): Observable<Employee[]> {

    let url = `${this.rootUrl}/search-by-name/${keyword}`;

    return this.authHttp.get(url).map(this.extractData);
  }

  getMyInfo(): Observable<any> {
    let url = `/api/hisemployee/employees/getMyInfo`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  getEmployeeInfoByEmployeeUuid(uuid: string): Observable<any> {
    let url = `/api/hisemployee/employees/${uuid}/`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  getEmployeeListAsObservable(): Observable<EmployeeListItem[]> {
    return this.employeeListBehaviorSubject.asObservable();
  }

  getEmployeeListByDepartmentId(departmentId: number):Observable<EmployeeListItem[]> {
    this.lastQueriedDepartmentId = departmentId;
    let url = `${this.rootUrl}/${this.lastQueriedDepartmentId}/employee-list`;
    return this.authHttp.get(url).map(this.extractData);
  }

  deleteEmployee(id: number):Observable<any> {
    return this.authHttp.delete(`${this.deleteEmployeeUrl}/${id}`).do(() => this.getEmployeeListByDepartmentId(this.lastQueriedDepartmentId));
  }

  createEmployee(value: any) {
    return this.authHttp.post(this.createEmployeeUrl, value).subscribe(() => this.employeeCreatedSubject.next());
  }

  updateEmployee(value: any) {
    return this.authHttp.put(this.updateEmployeeUrl, value).subscribe(() => this.employeeUpdatedSubject.next());
  }

  updateEmployeeLoginAccount(value: any): Observable<boolean> {
    return this.authHttp.put(this.updateEmployeeLoginAccountUrl, value).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updatePassword(value: any) {
    return this.authHttp.put(this.updateEmployeePasswordUrl, value).subscribe(() => this.employeeUpdatedSubject.next())
  }

  moveEmployeeToDepartment(bundle: any):Observable<any> {
    return this.authHttp.put(this.moveEmployeeToDepartmentUrl, bundle).map(this.extractData);
  }


  setAsManager(empId: number):Observable<any> {
    return this.authHttp.put(this.setAsManagerUrl, {'id': empId}).map(this.extractData);
  }

  getHanYuPinYin(text: any): Observable<any> {
    return this.authHttp.get(`${this.getHanYuPinYinUrl}/${text}`).map(this.extractTextData);
  }
}
