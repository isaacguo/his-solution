import {OnDestroy, OnInit} from "@angular/core";
import {Subscription} from "rxjs/Subscription";
import {AuthorizationInfo, AuthorizationService} from "../../core/services/common/authorization.service";
import {AuthorizationAssignment} from "../../core/models/authorization/authorization-assignment.model";
import {Observable} from "rxjs/Observable";
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from "@angular/router";

export class GuardDelegation implements OnInit, OnDestroy, CanActivate {


  authorizationInfo: AuthorizationInfo;
  private authorizationChangeSubscription: Subscription;

  constructor(private service: string, private topic: string, private operation: string, private authorizationService: AuthorizationService) {
    this.authorizationChangeSubscription = this.authorizationService.authorizationChange.subscribe(
      authorizationInfo =>
        this.authorizationInfo = authorizationInfo);
  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.authorizationChangeSubscription.unsubscribe();
  }

  isAuthorized(): Observable<boolean> {
    if (!this.authorizationInfo.authorizationAssignmentArray.has(this.service)) {
      return Observable.of(false);
    }
    else {
      let assignments: AuthorizationAssignment[] = this.authorizationInfo.authorizationAssignmentArray.get(this.service);
      let index = assignments.findIndex(r => r.topic.name === this.topic);
      if (index < 0) return Observable.of(false);
      else {
        let assignmentIndex = assignments[index].allowedOperations.findIndex(op => op.name === this.operation);
        if (assignmentIndex < 0) return Observable.of(false);
        else {
          return Observable.of(true);
        }
      }
    }
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):  boolean {
    if (!this.authorizationInfo.authorizationAssignmentArray.has(this.service)) {
      return false;
    }
    else {
      let assignments: AuthorizationAssignment[] = this.authorizationInfo.authorizationAssignmentArray.get(this.service);
      let index = assignments.findIndex(r => r.topic.name === this.topic);
      if (index < 0) return false;
      else {
        let assignmentIndex = assignments[index].allowedOperations.findIndex(op => op.name === this.operation);
        if (assignmentIndex < 0) return false;
        else {
          return true;
        }
      }
    }
  }
}
