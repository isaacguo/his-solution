import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {TreatmentCase} from "../../../dto/treatment/treatment-case.model";
import {TreatmentCaseService} from "../../../services/treatment/treatment-case.service";
import {TreatmentCaseComment} from "../../../dto/treatment/treatment-comment.model";
import {ActivatedRoute} from "@angular/router";
import {map} from "rxjs/operators";
import {combineLatest} from "rxjs/observable/combineLatest";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {CommentService} from "../../../services/treatment/comment.service";


@Component({
  selector: 'app-treatment-comments-container',
  templateUrl: './treatment-comments-container.component.html',
  styleUrls: ['./treatment-comments-container.component.css']
})
export class TreatmentCommentsContainerComponent implements OnInit {

  selectedTreatmentCase: Observable<TreatmentCase>;
  selectedTreatmentCaseUuid: Observable<string>;
  selectedTreatmentCaseUuidBehaviorSubject = new BehaviorSubject<string>('');
  treatmentCaseComments: Observable<TreatmentCaseComment[]>;

  filteredTreatmentCases: Observable<TreatmentCase[]>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private commentService: CommentService,
              private route: ActivatedRoute) {

    this.filteredTreatmentCases = this.treatmentCaseService.getItems();

    this.selectedTreatmentCaseUuid = this.selectedTreatmentCaseUuidBehaviorSubject.asObservable();
    //this.selectedTreatmentCaseUuid = this.selectedTreatmentCaseUuid || Observable.of('');

    this.selectedTreatmentCase = combineLatest(
      this.filteredTreatmentCases,
      this.selectedTreatmentCaseUuid
    ).pipe(
      map(([treatmentCases, selectedTreatmentCaseUuid]) => {
          if (selectedTreatmentCaseUuid === '')
            return treatmentCases[0];
          else
            return treatmentCases.find((treatmentCase) => treatmentCase.uuid === selectedTreatmentCaseUuid)
        }
      )
    );

    this.treatmentCaseComments = this.selectedTreatmentCase.pipe(map(treatmentCase => {
      return treatmentCase.comments;
    }))
  }


  onTreatmentCaseSelected(treatmentCase: TreatmentCase) {
    this.selectedTreatmentCaseUuidBehaviorSubject.next(treatmentCase.uuid);
  }

  onCreateComment(event) {
    //this.commentService.createItem({...event});
    this.commentService.createComment({...event}).subscribe(() => this.treatmentCaseService.loadData());

  }


  onSearchCriteriaCreated(event) {

  }

  ngOnInit(): void {
    this.treatmentCaseService.loadData();
  }
}
