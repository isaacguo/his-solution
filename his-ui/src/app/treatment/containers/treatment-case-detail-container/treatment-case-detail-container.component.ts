import {Component, OnInit} from '@angular/core';
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentCase} from "../../models/treatment-case.model";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-treatment-case-detail-container',
  templateUrl: './treatment-case-detail-container.component.html',
  styleUrls: ['./treatment-case-detail-container.component.css']
})
export class TreatmentCaseDetailContainerComponent implements OnInit {

  treatmentCaseChangedSubject=new BehaviorSubject<any>({});
  treatmentCase$: Observable<TreatmentCase>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route: ActivatedRoute,
              private router: Router
  ) {
    this.treatmentCase$ = route.params.mergeMap(p => {
      return this.treatmentCaseService.readOne(p['treatmentCaseId']);
    });
  }

  ngOnInit() {

  }

  onTreatmentCaseSaved($event: any) {
    this.treatmentCaseService.update($event.id,$event);
  }
}
