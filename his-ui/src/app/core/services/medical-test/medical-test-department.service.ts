import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {Observable} from "rxjs/Rx";
import {TreeNodeService} from "../common/tree-node.service";
import {AuthHttp} from "angular2-jwt";
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";
import {Department} from "../../../treatment/models/department.model";

@Injectable()
export class MedicalTestDepartmentService extends CrudService<any> {


  rootUrl: string = `${ServiceConstants.MEDICALTEST_URL}/departments`;


  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.MEDICALTEST_URL}/departments`, authHttp);
  }

  getDepartments(): Observable<any[]> {

    return this.authHttp.get(`${this.rootUrl}`)
      .map(this.extractData);
  }

  getAllEnabledDepartments(): Observable<any[]>{
    return this.authHttp.get(`${this.rootUrl}/getAllEnabledDepartments`)
      .map(this.extractData);
  }



  getDepartmentByDepId(depId: number, depName: string): Observable<Department> {
    let url = `${this.rootUrl}/getDepartmentByDepId/${depId}/`;
    return this.authHttp.get(url).map(this.extractData).map(data => {
      return {...data, name: depName}
    });
  }

  /*
  getDepartmentByDepId(depId: string): Observable<any> {
    let url = `${this.rootUrl}/getDepartmentByDepId/${depId}/`;
    return this.authHttp.get(url)
      .map(this.extractData);

  }
  */

  setDepartmentEnable(departmentId: number, departmentName: string, state: boolean): Observable<boolean> {

    let request: any = {};
    request.enable = state;
    request.name = departmentName;
    request.depId = departmentId;

    let url = `${this.rootUrl}/setDepartmentEnable`;
    return this.authHttp.post(url, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  addSupportedTestReportTemplate(depId: number, testReportTemplateId: number) {

    let request: any = {};
    request.depId = depId;
    request.testReportTemplateId = testReportTemplateId;

    let url = `${this.rootUrl}/addSupportedTestReportTemplate`;
    return this.authHttp.post(url, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  removeSupportedTestReportTemplate(depId: number, testReportTemplateId: number) {

    let request: any = {};
    request.depId = depId;
    request.testReportTemplateId = testReportTemplateId;

    let url = `${this.rootUrl}/removeSupportedTestReportTemplate`;
    return this.authHttp.post(url, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
