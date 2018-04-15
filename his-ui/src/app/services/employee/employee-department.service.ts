import {Injectable} from '@angular/core';
import {DepartmentListItem} from "../../dto/employee/department-list-item.model";
import {Observable} from "rxjs/Rx";
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class EmployeeDepartmentService extends AbstractService {

  constructor(private authHttp: AuthHttp) {
    super();
  }

  private rootUrl: string = "/api/hisemployee/departments";
  private getDepartmentListUrl: string = "/api/hisemployee/departments/brief";


  getDepartmentList(): Observable<DepartmentListItem[]> {
    return this.authHttp.get(this.getDepartmentListUrl).map(this.extractData);
  }
}
