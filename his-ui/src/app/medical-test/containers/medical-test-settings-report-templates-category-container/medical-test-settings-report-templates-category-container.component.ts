import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {MedicalTestReportTemplate} from "../../models/medical-test-report-template.model";
import {BehaviorSubject, Observable} from "rxjs";
import {combineLatest} from "rxjs/observable/combineLatest";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";

@Component({
  selector: 'app-medical-test-settings-report-templates-category-container',
  templateUrl: './medical-test-settings-report-templates-category-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-category-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesCategoryContainerComponent implements OnInit {

  reportTemplateList$: Observable<MedicalTestReportTemplate[]>;

  operationDoneSubject = new BehaviorSubject<boolean>(false);
  operationDone$ = this.operationDoneSubject.asObservable();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private treeNodeService: TreeNodeService,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService
  ) {
    this.reportTemplateList$ = combineLatest(route.params, this.operationDone$).mergeMap(([params, managerSet]) => {
      return this.medicalTestReportTemplateService.findReportTemplatesByCategoryId(params['categoryId']);
    });
  }

  ngOnInit() {
  }

  onCreateNewReportTemplate() {
    this.route.params.subscribe(params => {
      this.router.navigate([OperationEnum.CREATE], {relativeTo: this.route});
    })
    ;
  }

  onEditNewReportTemplate(event: number) {
    this.route.params.subscribe(params => {
      this.router.navigate([OperationEnum.UPDATE, event], {relativeTo: this.route});
    });
  }


  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();
  onRemoveReportTemplate($event: number) {
    this.medicalTestReportTemplateService.deleteById($event).subscribe(() => {
      this.operationDoneSubject.next(true)

      this.popupBundleSubject.next({
        title: '信息',
        body: '模板删除成功',
        hasConfirmButton: true,
        confirmButtonText: "确定",
      })

    });
  }
}
