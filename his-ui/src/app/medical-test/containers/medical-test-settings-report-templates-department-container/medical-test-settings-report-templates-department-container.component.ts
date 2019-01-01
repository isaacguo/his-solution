import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {MedicalTestReportTemplateCategoryService} from "../../../core/services/medical-test/medical-test-report-template-category.service";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-medical-test-settings-report-templates-department-container',
  templateUrl: './medical-test-settings-report-templates-department-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-department-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesDepartmentContainerComponent {

  //reportTemplates$: Observable<any>;

  categoryNodes$: Observable<MyTreeNode[]>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService,
    private medicalTestReportTemplateCategoryService: MedicalTestReportTemplateCategoryService
  ) {

    /*
    this.reportTemplates$ = this.route.params.mergeMap((p) => {
      return this.medicalTestReportTemplateService.findReportTemplatesByDepartmentId(p['departmentId']);
    })
    */

    this.categoryNodes$ = this.medicalTestReportTemplateCategoryService.getNodes();

  }

  onCreateNewTemplateClicked() {
    this.route.params.take(1).subscribe(
      p =>
        this.router.navigate(['medical-test', 'settings', 'report-templates',
          'departments', p['departmentId'], 'create'])
    )
  }

  selectedNodeSubject = new BehaviorSubject<MyTreeNode>(new MyTreeNode());

  onNodeSelected(event) {
    this.selectedNodeSubject.next(event);
    this.router.navigate(['medical-tests', event.id], {relativeTo: this.route});
  }

  getSelectedNode(): Observable<MyTreeNode> {
    return this.selectedNodeSubject.asObservable();
  }

  getNodes(): Observable<MyTreeNode[]> {
    return this.categoryNodes$;
  }


  onNodeDeleted(event: MyTreeNode) {
    //this.employeeDepartmentService.deleteDepartment(event.id);
  }

  onNodeUpdated(event: MyTreeNode) {

  }

  onNodeExpanded() {
    //this.appEmployeeManagementCategoryTree.expandTree();
  }

  onRootNodeCreated($event: MyTreeNode) {
  }

  onSubNodeCreated(event: MyTreeNode) {
    //this.employeeDepartmentService.createDepartment(event.id, event.name)


  }

}
