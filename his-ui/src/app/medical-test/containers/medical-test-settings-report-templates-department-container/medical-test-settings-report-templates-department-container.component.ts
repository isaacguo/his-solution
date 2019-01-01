import {ChangeDetectionStrategy, Component, OnInit, ViewChild} from '@angular/core';
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {MedicalTestReportTemplateCategoryService} from "../../../core/services/medical-test/medical-test-report-template-category.service";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {combineLatest} from "rxjs/observable/combineLatest";
import {EmployeeManagementCategoryTreeComponent} from "../../../employee/components/employee-management-category-tree/employee-management-category-tree.component";
import {MedicalTestSettingsReportTemplateListComponent} from "../../components/medical-test-settings-report-template-list/medical-test-settings-report-template-list.component";

@Component({
  selector: 'app-medical-test-settings-report-templates-department-container',
  templateUrl: './medical-test-settings-report-templates-department-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-department-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesDepartmentContainerComponent {

  //reportTemplates$: Observable<any>;

  categoryNodes$: Observable<MyTreeNode[]>;
  operationDoneSubject = new BehaviorSubject<boolean>(false);
  operationDone$ = this.operationDoneSubject.asObservable();

  @ViewChild("tree")
  medicalTestSettingsReportTemplateListComponent: MedicalTestSettingsReportTemplateListComponent;


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

    //this.categoryNodes$ = this.medicalTestReportTemplateCategoryService.getNodes();

    this.categoryNodes$ = combineLatest(this.route.params, this.operationDone$).mergeMap(([params, op]) => {
      return this.medicalTestReportTemplateCategoryService.getNodesByDepartmentId(params['departmentId'])
    });

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

    this.medicalTestReportTemplateCategoryService.deleteOne(event.id)
      .subscribe(() => {
        this.operationDoneSubject.next(true)
      });
  }

  onNodeUpdated(event: MyTreeNode) {
    this.medicalTestReportTemplateCategoryService.update(event.id, {'id': event.id, 'name': event.name})
      .subscribe(() => {
        this.operationDoneSubject.next(true)
      });

  }

  onNodeExpanded() {
    this.medicalTestSettingsReportTemplateListComponent.expandTree();
  }

  onRootNodeCreated($event: MyTreeNode) {
    this.route.params.take(1).mergeMap((params) => {
      return this.medicalTestReportTemplateCategoryService.create({
        'name': $event.name,
        'departmentId': params['departmentId']
      })
    })
      .subscribe(() => {
        this.operationDoneSubject.next(true)
      });
  }

  onSubNodeCreated(event: MyTreeNode) {

    this.route.params.take(1).mergeMap((params) => {
      return this.medicalTestReportTemplateCategoryService.create({
        'parentId': event.id,
        'name': event.name,
        'departmentId': params['departmentId']
      })
    })
      .subscribe(() => {
        this.operationDoneSubject.next(true)
      });

  }

}
