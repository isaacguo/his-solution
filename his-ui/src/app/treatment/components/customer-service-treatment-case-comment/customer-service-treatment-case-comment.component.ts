import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentCaseComment} from "../../models/treatment-comment.model";

@Component({
  selector: 'app-customer-service-treatment-case-comment',
  templateUrl: './customer-service-treatment-case-comment.component.html',
  styleUrls: ['./customer-service-treatment-case-comment.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
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
