import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentCaseComment} from "../../models/treatment-comment.model";
import {TreatmentCase} from "../../models/treatment-case.model";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-service-treatment-case-comments',
  templateUrl: './customer-service-treatment-case-comments.component.html',
  styleUrls: ['./customer-service-treatment-case-comments.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerServiceTreatmentCaseCommentsComponent implements OnInit {

  @Input()
  comments: TreatmentCaseComment[];
  @Input()
  treatmentCase: TreatmentCase;


  @Output() updateCommentEvent = new EventEmitter<any>();
  @Output() createCommentEvent = new EventEmitter<TreatmentCaseComment>();


  commentForm: FormGroup;

  constructor(private fb: FormBuilder,) {
  }

  onCreateComment() {
    this.createCommentEvent.emit({
      content: this.commentForm.controls['content'].value,
      treatmentCaseUuid: this.treatmentCase.uuid
    });
    this.commentForm.controls['content'].setValue('');
  }


  ngOnInit() {
    this.commentForm = this.fb.group({
      'content': [''],
    });
  }

}
