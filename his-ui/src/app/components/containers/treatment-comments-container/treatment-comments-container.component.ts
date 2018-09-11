import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {TreatmentCase} from "../../../dto/treatment/treatment-case.model";
import {TreatmentCaseService} from "../../../services/treatment/treatment-case.service";
import {TreatmentComment} from "../../../dto/treatment/treatment-comment.model";
import {ActivatedRoute} from "@angular/router";
import {map} from "rxjs/operators";
import {combineLatest} from "rxjs/observable/combineLatest";


@Component({
  selector: 'app-treatment-comments-container',
  templateUrl: './treatment-comments-container.component.html',
  styleUrls: ['./treatment-comments-container.component.css']
})
export class TreatmentCommentsContainerComponent  {

  selectedTreatmentCase: Observable<TreatmentCase>;
  treatmentCaseComments: Observable<TreatmentComment[]>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route:ActivatedRoute) {
    this.selectedTreatmentCase=combineLatest(
      this.treatmentCaseService.getItems(),
      route.parent.params
    ).pipe(
      map(([treatmentCases, routeParams]) =>
        treatmentCases.find((treatmentCase) => treatmentCase.id === +routeParams.treatmnetCaseId)
      )
    );

    this.treatmentCaseComments=this.selectedTreatmentCase.pipe(map(treatmentCase=>treatmentCase.comments))
  }

}
