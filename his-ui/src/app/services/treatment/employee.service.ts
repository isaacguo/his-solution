import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {AbstractService} from "../abstract.service";
import {Employee} from "../../dto/employee.model";

@Injectable()
export class EmployeeService extends AbstractService {

  rootUrl: string = "/api/histreatment/employees";

  constructor(private authHttp: AuthHttp) {
    super();
  }



}
