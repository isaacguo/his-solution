import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {EmployeeCount} from "../../employee/models/employee.count.model";
import {Employee} from "../../employee/models/employee.model";
import {EmployeeListItem} from "../../employee/models/employee-list-item.model";
import {ServiceConstants} from "../../shared/service-constants";
import {AbstractService} from "../../core/services/abstract.service";


@Injectable()
export class EmployeeService extends AbstractService {

  private rootUrl: string = `${ServiceConstants.EMPLOYEE_URL}/employees`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  findEmployeesByNameContains(keyword: string): Observable<Employee[]> {

    let url = `${this.rootUrl}/search-by-name/${keyword}`;

    return this.authHttp.get(url).map(this.extractData);
  }


}
