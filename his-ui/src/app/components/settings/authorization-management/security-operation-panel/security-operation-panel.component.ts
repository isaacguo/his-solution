import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthorizationTopic} from "../../../../dto/authorization/authorization-topic.model";
import {UserAccountAuthorizationAssignmentItem} from "../../../../dto/authorization/user-account-authorization-assignment-item.model";
import {AuthorizationAssignment} from "../../../../dto/authorization/authorization-assignment.model";
import {AuthorizationService} from "../../../../services/common/authorization.service";
import {Authorization} from "../../../../dto/authorization/authorization.model";
import {TopicOperation} from "../../../../dto/authorization/topic-operation.model";
import {EmployeeService} from "../../../../services/employee/employee.service";
import {Employee} from "../../../../dto/employee.model";
import {Observable} from "rxjs/Observable";
import {AuthorizationOperationRequest} from "../../../../dto/authorization/authorization-operation-request.model";
import {AuthorizationAssignmentOperationRequest} from "../../../../dto/authorization/authorization-assignment-operation-request.model";

@Component({
  selector: 'app-security-operation-panel',
  templateUrl: './security-operation-panel.component.html',
  styleUrls: ['./security-operation-panel.component.css']
})
export class SecurityOperationPanelComponent implements OnInit {

  @Input()
  key: [string, string];

  @Input()
  authorizations: Authorization[];

  employees: Employee[] = [];

  loading: boolean;
  authorizationTopics: AuthorizationTopic[] = [];

  newUser: string;
  private assignmentMap: Map<string, Authorization[]> = new Map<string, Authorization[]>();
  //assignmentArray: UserAccountAuthorizationAssignmentItem[];
  formModel: FormGroup;

  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);


  constructor(private employeeService: EmployeeService, private authorizationService: AuthorizationService, private fb: FormBuilder) {

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          return this.employeeService.findEmployeesByNameContains(name);
        }
      })
      .subscribe(r => {
        this.employees = r;
      })

    //this.initEmployeeArray();
  }

  private initEmployeeArray() {
    const e: Employee = {};
    e.surname = "请输入人员关键字";
    this.employees.push(e);
  }

  onCheckAllButtonClicked(authorization: Authorization) {

    authorization.authorizationAssignmentList.forEach((r, index) => {

      r.allowedOperations = [];
      this.getAuthorizationTopicById(r.topic.id).availableTopicOperationList.forEach(op => {
        r.allowedOperations.push(op);
      })

    })

  }

  getAuthorizationTopicById(id: number): AuthorizationTopic {
    let obj = this.authorizationTopics.find(r => {

      return r.id === id;
    });
    return obj;

  }

  onUnCheckAllButtonClicked(authorization: Authorization) {
    authorization.authorizationAssignmentList.forEach((r, index) => {
      r.allowedOperations = [];
    })
  }

  onDeleteUserButtonClicked(index: number) {
    this.authorizationService.deleteAuthorization(this.key[0], this.authorizations[index].id).subscribe(r => {
      this.loadData();
    });
  }


  onSaveButtonClicked(authorization: Authorization) {
    const authorizationOperationRequest: AuthorizationOperationRequest = new AuthorizationOperationRequest();
    authorizationOperationRequest.id = authorization.id;
    authorizationOperationRequest.authorizationAssignmentList = [];

    authorization.authorizationAssignmentList.forEach(r => {
      const req: AuthorizationAssignmentOperationRequest = new AuthorizationAssignmentOperationRequest();
      req.topicId = r.topic.id;
      req.allowedOperationIds = r.allowedOperations.map(op => op.id);

      authorizationOperationRequest.authorizationAssignmentList.push(req);
    });

    this.authorizationService.updateAuthorizationAssignment(this.key[0], authorizationOperationRequest).subscribe(r => {
      this.loadData();
    });
  }


  private loadData() {
    this.authorizationService.getAuthorizations(this.key[0]).subscribe(z => {
      this.authorizations = z;
    });
  }

  ngOnInit() {
    if (this.key != null) {
      this.authorizationService.getAuthorizationTopics(this.key[0]).subscribe(r => {
        this.authorizationTopics = r;
      })
    }
  }


  onChange(authorization: Authorization, assignment: AuthorizationAssignment, op: TopicOperation, isChecked: boolean) {

    if (isChecked)
      assignment.allowedOperations.push(op);
    else {
      let index = assignment.allowedOperations.findIndex(r => {
        return r.id === op.id;
      });

      if (index > -1) {
        //this.authorizations.find(r=>r.id===authorization.id).authorizationAssignmentList.find(r=>r.id===assignment.id).allowedOperations.slice(index,1);
        assignment.allowedOperations.splice(index, 1);
      }
    }
  }

  isCheckedByDefault(assignment: AuthorizationAssignment, op: TopicOperation): boolean {

    return assignment.allowedOperations.findIndex(r => r.id === op.id) > -1 ? true : false;
  }

  onSubmit() {
    //this.employeeService.
  }


  onRefreshIconClicked() {
    this.loadData();
  }

  getStatus() {

    if (!this.loading)
      return "pull-right fa fa-refresh fa-fw isaac-margin-10bottom";
    else
      return "pull-right fa fa-refresh fa-spin fa-fw isaac-margin-10bottom";
  }


  stopPropagation($event) {
    event.stopPropagation()
  }


  onEmployeeSelected(e: Employee) {
    this.employees = [];
    this.searchInput.setValue("");
    this.authorizationService.createAuthorization(this.key[0], e.loginAccount, e.surname + e.givenName, e.id).subscribe(r => {
      this.loadData();
    })
  }


}
