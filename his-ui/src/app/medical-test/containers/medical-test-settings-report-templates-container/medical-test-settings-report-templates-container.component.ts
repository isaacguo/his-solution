import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestDepartmentService} from "../../../core/services/medical-test/medical-test-department.service";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {combineLatest} from "rxjs/observable/combineLatest";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-medical-test-settings-report-templates-container',
  templateUrl: './medical-test-settings-report-templates-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesContainerComponent {

  selectedDepartment$: Observable<any>;

  enabledDepartments: Observable<any[]>;
  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();

  constructor(private router: Router,
              private medicalTestDepartmentService: MedicalTestDepartmentService,
              private treeNodeService: TreeNodeService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private route: ActivatedRoute,) {


    this.enabledDepartments = this.medicalTestDepartmentService.getAllEnabledDepartments().shareReplay(2);

    this.selectedDepartment$ = combineLatest(this.route.url, this.enabledDepartments).map(([route, deps]) => {
      return deps.find((dep) => {
        return this.router.isActive(`/medical-test/settings/report-templates/departments/${dep.depId}`, false)
      })
    })

    this.enabledDepartments.subscribe(deps=>{
      if(deps.length>0)
        this.router.navigate(['medical-test', 'settings', 'report-templates', 'departments', deps[0].depId])
      else
      {
        this.popupBundleSubject.next({
          title: '信息',
          body: '<h4>尚未设置化验科室，请至<b>科室设置</b>设置化验科室</h4>',
          hasConfirmButton: true,
          confirmButtonText: "确定",
        })
      }
    })
  }

  onTagSelected(department: any) {
    //below code would not trigger the combinLatest, why?
    //this.router.navigate(['departments', department.depId], {relativeTo: this.route});
    this.router.navigate(['medical-test', 'settings', 'report-templates', 'departments', department.depId])
  }
}
