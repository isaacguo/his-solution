import {Injectable, OnDestroy} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {Authorization} from "../../dto/authorization/authorization.model";
import {AbstractService} from "../abstract.service";
import {AuthorizationTopic} from "../../dto/authorization/authorization-topic.model";
import {AuthorizationOperationRequest} from "../../dto/authorization/authorization-operation-request.model";
import {AuthorizationAssignment} from "../../dto/authorization/authorization-assignment.model";
import {AuthenticationService, AuthInfo, AuthState} from "./authentication.service";
import {Subscription} from "rxjs/Subscription";
import {forkJoin} from "rxjs/observable/forkJoin";
import {Router} from "@angular/router";

@Injectable()
export class AuthorizationService extends AbstractService implements OnDestroy {

  static serviceMap: Map<string, string> = new Map<string, string>();
  authorizationArray: [string, string][] = [];
  authorizationAssignmentArray: Map<string, AuthorizationAssignment[]> = new Map<string, AuthorizationAssignment[]>();
  authInfo: AuthInfo;
  private authChangeSubscription: Subscription;

  constructor(private router: Router,private authHttp: AuthHttp, private authenticationService: AuthenticationService) {
    super();
    this.authorizationArray.push(["/api/hisprocurement", "采购模块权限"]);
    this.authorizationArray.push(["/api/hisemployee", "人事模块权限"]);

    AuthorizationService.serviceMap.set("Procurement", "/api/hisprocurement");
    AuthorizationService.serviceMap.set("Employee", "/api/hisemployee");

    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo => {
        this.authInfo = newAuthInfo;
        if (this.authInfo.authState === AuthState.LoggedIn) {
          this.getMyAuthorizations();
        }
      }
    );
  }

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
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

  isAuthorized(serviceName: string, topic: string, operation: string): boolean {

    if (!this.authorizationAssignmentArray.has(serviceName)) {

      return false;
    }
    else {
      let assignments: AuthorizationAssignment[] = this.authorizationAssignmentArray.get(serviceName);
      let index = assignments.findIndex(r => r.topic.name === topic);
      if (index < 0) return false;
      else {
        let assignmentIndex = assignments[index].allowedOperations.findIndex(op => op.name === operation);
        if (assignmentIndex < 0) return false;
        else {
          return true;
        }
      }
    }
  }

  getMyAuthorizations() {

    var sou = Observable.from(Array.from(AuthorizationService.serviceMap.entries()));

    sou.mergeMap(entry => this.authHttp.get(`${entry[1]}/authorizations/get-my-authorizations`).map(this.extractData))
      .subscribe(r => {
        this.authorizationAssignmentArray.set(r.name, r.assignments);
      },(err)=>{},()=>{
        this.router.navigate(['/dashboard']);
      });


    /*
        AuthorizationService.serviceMap.forEach((value: string, key: string) => {
          this.authHttp.get(`${value}/authorizations/get-my-authorizations`).map(this.extractData).subscribe(r => {
            this.authorizationAssignmentArray.set(key, r);
          });
        });
        */
  }
}
