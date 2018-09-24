import {Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {TreatmentCaseComment} from "../../../models/treatment-comment.model";
import {TreatmentCase} from "../../../models/treatment-case.model";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-service-comments',
  templateUrl: './customer-service-comments.component.html',
  styleUrls: ['./customer-service-comments.component.css']
})
export class CustomerServiceCommentsComponent implements OnInit {

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
