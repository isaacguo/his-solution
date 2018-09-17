import {OnDestroy, OnInit} from "@angular/core";
import {AuthorizationInfo, AuthorizationService} from "../services/common/authorization.service";
import {Subscription} from "rxjs/Subscription";
import {AuthorizationAssignment} from "../dto/authorization/authorization-assignment.model";

export class AbstractGuard implements OnInit, OnDestroy {


  protected service:string;
  protected topic: string;
  protected operation: string;

  authorizationInfo: AuthorizationInfo;
  private authorizationChangeSubscription: Subscription;

  constructor(service:string, topic: string, operation: string,private authorizationService: AuthorizationService) {

    this.service=service;
    this.topic=topic;
    this.operation=operation;

    this.authorizationChangeSubscription = this.authorizationService.authorizationChange.subscribe(
      authorizationInfo =>
        this.authorizationInfo = authorizationInfo);
  }

  ngOnInit(): void {

  }

  ngOnDestroy(): void {
    this.authorizationChangeSubscription.unsubscribe();
  }

  isAuthorized(): boolean {
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
