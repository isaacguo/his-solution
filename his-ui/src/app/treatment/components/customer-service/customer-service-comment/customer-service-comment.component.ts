import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentCaseComment} from "../../../models/treatment-comment.model";

@Component({
  selector: 'app-customer-service-comment',
  templateUrl: './customer-service-comment.component.html',
  styleUrls: ['./customer-service-comment.component.css']
})
export class CustomerServiceCommentComponent  {

  @Input()
  comment: TreatmentCaseComment;
  @Output()
  updateCommentEvent = new EventEmitter<any>();


  constructor() {
  }

  updateComment(content: string) {
    this.updateCommentEvent.emit({
      ...this.comment,
      content
    });
  }
}
