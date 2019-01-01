import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {MedicalTestReportTemplate} from "../../models/medical-test-report-template.model";
import {BehaviorSubject, Observable} from "rxjs";
import {combineLatest} from "rxjs/observable/combineLatest";
import {OperationEnum} from "../../../core/enums/operation.enum";

@Component({
  selector: 'app-medical-test-settings-report-templates-category-container',
  templateUrl: './medical-test-settings-report-templates-category-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-category-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesCategoryContainerComponent implements OnInit {

  reportTemplateList$:Observable<MedicalTestReportTemplate[]>;

  operationDoneSubject = new BehaviorSubject<boolean>(false);
  operationDone$ = this.operationDoneSubject.asObservable();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private treeNodeService: TreeNodeService,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService
  ) {
    this.reportTemplateList$=combineLatest(route.params,this.operationDone$).mergeMap(([params, managerSet]) => {
      return this.medicalTestReportTemplateService.findReportTemplatesByCategoryId(params['categoryId']);
    });
  }

  ngOnInit() {
  }

  onCreateNewReportTemplate() {
    this.route.params.subscribe(params => {
      this.router.navigate([OperationEnum.CREATE], {relativeTo: this.route});
      //console.log(params)
      //this.router.navigate(['medical-test','settings','report-templates','departments']);
    })
    ;
  }
}
