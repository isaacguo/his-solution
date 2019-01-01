import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicalTestReportTemplate} from "../../models/medical-test-report-template.model";

@Component({
  selector: 'app-medical-test-settings-report-template-category-detail',
  templateUrl: './medical-test-settings-report-template-category-detail.component.html',
  styleUrls: ['./medical-test-settings-report-template-category-detail.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplateCategoryDetailComponent implements OnInit {

  @Input()
  canCreateNewItem: boolean = true;
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;

  @Input()
  categoryName: string;

  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;

  @Input()
  reportTemplateList:MedicalTestReportTemplate[];

  @Output()
  createNewReportTemplate=new EventEmitter();

  @Output()
  editNewReportTemplate=new EventEmitter<number>();
  @Output()
  removeReportTemplate=new EventEmitter<number>();
  reportToBeDeleted: MedicalTestReportTemplate;

  constructor() { }

  ngOnInit() {

  }

  onCreateNewReportClicked() {
    this.createNewReportTemplate.emit();
  }

  onEditButtonClicked(report: MedicalTestReportTemplate) {
    this.editNewReportTemplate.emit(report.id);
  }

  onRemoveReport(report: MedicalTestReportTemplate) {

    this.reportToBeDeleted = report;
    this.confirmDeletionModal.open();
  }

  onConfirmDeletionModalClosed() {
    this.removeReportTemplate.emit(this.reportToBeDeleted.id);
  }
}
