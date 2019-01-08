import {Component, OnInit} from '@angular/core';
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentCase} from "../../models/treatment-case.model";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {combineLatest} from "rxjs/observable/combineLatest";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";

@Component({
  selector: 'app-treatment-case-detail-container',
  templateUrl: './treatment-case-detail-container.component.html',
  styleUrls: ['./treatment-case-detail-container.component.css']
})
export class TreatmentCaseDetailContainerComponent implements OnInit {

  treatmentCaseChangedSubject = new BehaviorSubject<boolean>(false);
  treatmentCaseChangedObservable$ = this.treatmentCaseChangedSubject.asObservable();
  treatmentCase$: Observable<TreatmentCase>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route: ActivatedRoute,
              private router: Router
  ) {

    this.treatmentCase$ = combineLatest(route.params, this.treatmentCaseChangedObservable$)
      .mergeMap(([params, e]) => {
        return this.treatmentCaseService.readOne(params['treatmentCaseId']);
      });
  }

  ngOnInit() {

  }

  onTreatmentCaseSaved($event: any) {
    this.treatmentCaseService.update($event.id, $event).subscribe(() => {

      this.popupBundleSubject.next({
        title: '成功',
        body: '<h4>保存成功</h4>',
        hasConfirmButton: true,
        confirmButtonText: "确定",
        payload: {'closeCase': false}
      })

      this.treatmentCaseChangedSubject.next(true);
    }, () => {

    });
  }

  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();

  onModalClosed($event) {
    this.treatmentCase$.take(1).mergeMap(tc => {
      if ($event.closeCase)
        return this.treatmentCaseService.closeTreatmentCase(tc.id)
      else {
        let m: TreatmentCase = {};
        return Observable.of(m);
      }
    }).subscribe(() => this.treatmentCaseChangedSubject.next(true));

  }

  onTreatmentCaseClosed($event: any) {

    this.popupBundleSubject.next({
      title: '请确定',
      body: '<h4>是否要关闭此病历?</h4>\n<h4 class="label label-danger isaac-font-medium ">病历关闭后，无法再次修改</h4>',
      hasConfirmButton: true,
      confirmButtonText: "确定",
      hasCancelButton: true,
      cancelButtonText: "取消",
      payload: {'closeCase': true}
    })

  }
}
