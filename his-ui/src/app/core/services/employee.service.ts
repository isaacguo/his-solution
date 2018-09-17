import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "./abstract.service";
import {EmployeeCount} from "../../employee/models/employee.count.model";
import {Employee} from "../../employee/models/employee.model";
import {EmployeeListItem} from "../../employee/models/employee-list-item.model";


@Injectable()
export class EmployeeService extends AbstractService {


  private rootUrl: string = "/api/hisemployee/employees";
  private deleteEmployeeUrl: string = `${this.rootUrl}/delete`;

  private createEmployeeUrl: string = `${this.rootUrl}/create`;

  private updateEmployeeUrl: string = `${this.rootUrl}/update`;
  private updateEmployeeLoginAccountUrl: string = `${this.rootUrl}/updateLoginAccount`;
  private updateEmployeePasswordUrl: string = `${this.rootUrl}/updatePassword`;
  private moveEmployeeToDepartmentUrl: string = `${this.rootUrl}/move-employee-to-department`;
  private setAsManagerUrl: string = `${this.rootUrl}/set-as-manager`;
  private getHanYuPinYinUrl: string = `${this.rootUrl}/getHanYuPinYin`;

  private _showEmployeeView: boolean = false;

  get showEmployeeView(): boolean {
    return this._showEmployeeView;
  }

  set showEmployeeView(value: boolean) {
    this._showEmployeeView = value;
  }


  constructor(private authHttp: AuthHttp) {
    super();
  }

  getEmployeeCount(): Observable<EmployeeCount> {
    let url = `/api/hisemployee/employees/counts`;
    return this.authHttp.get(url).map(this.extractData);
  }

  getEmployees(): Observable<Employee[]> {

    let url = `/api/hisemployee/employees`;
    return this.authHttp.get(url)
      .map(this.extractData);
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

  getEmployeeListByDepartmentId(departmentId: number): Observable<EmployeeListItem[]> {
    let url = `/api/hisemployee/employees/${departmentId}/employee-list`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }


  deleteEmployee(id: number | undefined): Observable<boolean> {
    return this.authHttp.delete(`${this.deleteEmployeeUrl}/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  createEmployee(value: any): Observable<boolean> {
    return this.authHttp.post(this.createEmployeeUrl, value).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updateEmployee(value: any): Observable<boolean> {
    return this.authHttp.put(this.updateEmployeeUrl, value).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updateEmployeeLoginAccount(value: any): Observable<boolean> {
    return this.authHttp.put(this.updateEmployeeLoginAccountUrl, value).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updatePassword(value: any): Observable<boolean> {
    return this.authHttp.put(this.updateEmployeePasswordUrl, value).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  moveEmployeeToDepartment(empId: number, depId: string): Observable<boolean> {
    return this.authHttp.put(this.moveEmployeeToDepartmentUrl, {'id': empId, 'departmentId': depId}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  setAsManager(empId: number): Observable<boolean> {
    return this.authHttp.put(this.setAsManagerUrl, {'id': empId}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  getHanYuPinYin(text: any): Observable<any> {
    return this.authHttp.get(`${this.getHanYuPinYinUrl}/${text}`).map(this.extractTextData);
  }
}
