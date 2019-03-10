import {ChangeDetectionStrategy, Component, EventEmitter, Output} from '@angular/core';
import {AbstractCategoryTreeComponent} from "../../../shared/components/abstract-category-tree/abstract-category-tree.component";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-medical-test-settings-report-template-list',
  templateUrl: './medical-test-settings-report-template-list.component.html',
  styleUrls: ['./medical-test-settings-report-template-list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})

export class MedicalTestSettingsReportTemplateListComponent extends AbstractCategoryTreeComponent  {

  selectedNodeSubject = new BehaviorSubject<MyTreeNode>(new MyTreeNode());

  @Output()
  createNewTemplateClick=new EventEmitter()

  constructor() {
    super();
  }

  ngOnInit() {
  }

  onCreateNewTemplateClicked() {
    this.createNewTemplateClick.emit();
  }
}
