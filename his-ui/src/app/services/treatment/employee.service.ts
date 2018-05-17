import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";

@Injectable()
export class EmployeeService extends AbstractService {

  rootUrl: string = "/api/histreatment/employees";

  constructor(private authHttp: AuthHttp) {
    super();
  }



}
