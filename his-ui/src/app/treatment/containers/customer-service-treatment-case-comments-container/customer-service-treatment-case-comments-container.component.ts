import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {TreatmentCase} from "../../models/treatment-case.model";
import {TreatmentCaseComment} from "../../models/treatment-comment.model";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute} from "@angular/router";
import {CommentService} from "../../../core/services/treatment/comment.service";

@Component({
  selector: 'app-customer-service-treatment-case-comments-container',
  templateUrl: './customer-service-treatment-case-comments-container.component.html',
  styleUrls: ['./customer-service-treatment-case-comments-container.component.css']
})
export class CustomerServiceTreatmentCaseCommentsContainerComponent implements OnInit {

  treatmentCase: Observable<TreatmentCase>;

  treatmentCaseComments: Observable<TreatmentCaseComment[]>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private commentService: CommentService,
              private route: ActivatedRoute) {

    this.treatmentCase = this.route.parent.params.mergeMap(r => this.treatmentCaseService.readOne(r['treatmentCaseId']));
    this.treatmentCaseComments = this.treatmentCase.mergeMap(r => {
      return this.commentService.findByTreatmentCaseUuid(r.uuid);
    });
  }

  onCreateComment(event) {
    this.commentService.createComment({
      ...event
    });
  }

  ngOnInit() {
  }

}
