import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {Authorization} from "../../dto/authorization/authorization.model";
import {AbstractService} from "../abstract.service";
import {AuthorizationTopic} from "../../dto/authorization/authorization-topic.model";
import {AuthorizationOperationRequest} from "../../dto/authorization/authorization-operation-request.model";

@Injectable()
export class AuthorizationService extends AbstractService {

  authorizationArray: [string, string][] = [];

  static serviceMap:Map<string,string>=new Map<string, string>();


  constructor(private authHttp: AuthHttp) {
    super();
    this.authorizationArray.push(["/api/hisprocurement", "采购模块权限"]);
    this.authorizationArray.push(["/api/hisemployee", "人事模块权限"]);

    AuthorizationService.serviceMap.set("Procurement", "/api/hisprocurement");

  }

  getAuthorizations(serviceUrl: string): Observable<Authorization[]> {
    return this.authHttp.get(`${serviceUrl}/authorizations`).map(this.extractData);
  }

  getAuthorizationTopics(serviceUrl: string): Observable<AuthorizationTopic[]> {
    return this.authHttp.get(`${serviceUrl}/authorization-topics`).map(this.extractData);
  }

  deleteAuthorization(serviceUrl: string, id: number): Observable<boolean> {
    return this.authHttp.delete(`${serviceUrl}/authorizations/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  createAuthorization(serviceUrl: string, userAccount: string, username: string, uid: number): Observable<boolean> {

    return this.authHttp.post(`${serviceUrl}/authorizations/create`, {
      'userAccount': userAccount,
      'username': username,
      'uid': uid
    }).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updateAuthorizationAssignment(serviceUrl: string, request: AuthorizationOperationRequest): Observable<boolean> {

    return this.authHttp.put(`${serviceUrl}/authorizations/update`, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  isAuthorized(serviceUrl: string, topic: string, operation: string): Observable<boolean> {
    return this.authHttp.get(`${serviceUrl}/authorizations/isAuthorized/${topic}/${operation}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }


}
