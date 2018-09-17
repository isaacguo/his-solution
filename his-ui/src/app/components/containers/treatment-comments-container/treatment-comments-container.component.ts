import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {map} from "rxjs/operators";
import {combineLatest} from "rxjs/observable/combineLatest";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Tab} from "../../../ui-controls/tabs/tab.model";
import {TreatmentCaseComment} from "../../../core/models/treatment/treatment-comment.model";
import {TreatmentCase} from "../../../core/models/treatment/treatment-case.model";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {CommentService} from "../../../core/services/treatment/comment.service";


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


  tabs: Tab[] = [
    {id: 'info', title: '宠物信息'},
    {id: 'detail', title: '病历详情'},
    {id: 'comment', title: '客户反馈'}
  ];
  activeTab: Observable<Tab>;


  /*
  activateTab(tab: Tab) {
    this.selectedProject
      .pipe(take(1))
      .subscribe((project: Project) => {
        this.router.navigate([
          '/projects',
          project.id,
          tab.id
        ]);
      });
  }
  */



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
      if (treatmentCase)
        return treatmentCase.comments;
      else
        return [];
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
