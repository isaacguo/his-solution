import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {TreatmentCaseComment} from "../../../../dto/treatment/treatment-comment.model";

@Component({
  selector: 'app-customer-service-treatment-case-comments',
  templateUrl: './customer-service-treatment-case-comments.component.html',
  styleUrls: ['./customer-service-treatment-case-comments.component.css']
})
export class CustomerServiceTreatmentCaseCommentsComponent {

  @Input()
  comments: TreatmentCaseComment[];

  @Output() updateCommentEvent = new EventEmitter<any>();
  @Output() createCommentEvent = new EventEmitter<TreatmentCaseComment>();

  @ViewChild('commentContentEditable') commentContentEditable: ElementRef;

  constructor() {
  }

  onCreateComment() {
    this.createCommentEvent.emit({
      content: this.commentContentEditable.nativeElement.textContent
    });
    this.commentContentEditable.nativeElement.textContent = '';
  }


}
