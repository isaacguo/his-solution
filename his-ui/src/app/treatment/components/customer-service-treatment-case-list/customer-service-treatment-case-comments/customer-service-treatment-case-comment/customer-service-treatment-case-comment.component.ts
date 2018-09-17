import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {TreatmentCaseComment} from "../../../../models/treatment-comment.model";

@Component({
  selector: 'app-customer-service-treatment-case-comment',
  templateUrl: './customer-service-treatment-case-comment.component.html',
  styleUrls: ['./customer-service-treatment-case-comment.component.css']
})
export class CustomerServiceTreatmentCaseCommentComponent {

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
