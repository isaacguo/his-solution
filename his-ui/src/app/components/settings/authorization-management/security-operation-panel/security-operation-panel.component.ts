import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthorizationTopic} from "../../../../dto/authorization/authorization-topic.model";
import {UserAccountAuthorizationAssignmentItem} from "../../../../dto/authorization/user-account-authorization-assignment-item.model";
import {AuthorizationAssignment} from "../../../../dto/authorization/authorization-assignment.model";
import {AuthorizationService} from "../../../../services/common/authorization.service";
import {Authorization} from "../../../../dto/authorization/authorization.model";
import {TopicOperation} from "../../../../dto/authorization/topic-operation.model";

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

  loading: boolean;
  authorizationTopics: AuthorizationTopic[] = [];

  newUser: string;
  private assignmentMap: Map<string, Authorization[]> = new Map<string, Authorization[]>();
  //assignmentArray: UserAccountAuthorizationAssignmentItem[];
  formModel: FormGroup;

  getAuthorizationTopicById(id: number): AuthorizationTopic {
    let obj = this.authorizationTopics.find(r => {

      return r.id === id;
    });

    console.log(obj);
    return obj;

  }


  constructor(private authorizationService: AuthorizationService, private fb: FormBuilder) {


    this.formModel = this.fb.group(
      {
        'newUser': ['', [Validators.required, Validators.minLength(5)]]
      });
  }

  onCheckAllButtonClicked(authorization: Authorization) {

    authorization.authorizationAssignmentList.forEach((r, index) => {

      r.allowedOperations = [];
      this.getAuthorizationTopicById(r.id).availableTopicOperationList.forEach(op => {
        r.allowedOperations.push(op);
      })

    })

  }

  onUnCheckAllButtonClicked(authorization: Authorization) {
    authorization.authorizationAssignmentList.forEach((r, index) => {
      r.allowedOperations = [];
    })
  }

  onDeleteUserButtonClicked(index: number) {
    /*
        const request = new AuthorizationAssignmentRequest();
        request.userAccount = this.assignmentArray[index].userAccount;
        this.authorizationService.deleteAuthorizationAssignment(request).subscribe(r => {
          this.loadData();
        })
        */

  }


  ngOnInit() {
    this.authorizationService.getAuthorizationTopics(this.key[0]).subscribe(r => {
      this.authorizationTopics = r;
    })
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

  }


  onSaveButtonClicked() {

  }

  onRefreshIconClicked() {

  }

  getStatus() {

    if (!this.loading)
      return "pull-right fa fa-refresh fa-fw isaac-margin-10bottom";
    else
      return "pull-right fa fa-refresh fa-spin fa-fw isaac-margin-10bottom";
  }


}
