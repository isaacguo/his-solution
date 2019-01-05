import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ReportStatusEnum} from "../../../core/enums/report-status.enum";
import {BehaviorSubject, Observable} from "rxjs";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {Pet} from "../../models/pet.model";
import {PetOwner} from "../../models/pet-owner.model";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";

@Component({
  selector: 'app-create-medical-tests',
  templateUrl: './create-medical-tests.component.html',
  styleUrls: ['./create-medical-tests.component.css']
})
export class CreateMedicalTestsComponent implements OnInit, OnChanges {


  @Input()
  treatmentCaseUuid: string;
  @Input()
  pet: Pet;
  @Input()
  petOwner: PetOwner;
  @Output()
  generateMedicalTestReport = new EventEmitter<any>();


  medicalTestReportTemplates: any[] = [];
  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  formModel: FormGroup;
  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();

  constructor(
    private fb: FormBuilder,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService
  ) {
    this.initFormModel();

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        } else {
          return this.medicalTestReportTemplateService.findMedicalTestReportTemplateByNameContains(name);
        }
      })
      .subscribe(r => {
        this.medicalTestReportTemplates = r;
      })
  }

  get medicalTestReportData() {
    return <FormArray>this.formModel.get('medicalTestReports');
  }

  stopPropagation($event) {
    event.stopPropagation()
  }

  ngOnInit() {
  }

  onMedicalTestReportTemplateSelected(medicalTestReportTemplate: any) {
    this.addMedicalTestReport(medicalTestReportTemplate.uuid, medicalTestReportTemplate.reportName);
  }

  minLengthArray(min: number) {
    return (c: AbstractControl): { [key: string]: any } => {
      if (c.value.length >= min)
        return null;
      return {'minLengthArray': {valid: false}};
    }
  }

  addMedicalTestReport(reportTemplateUuid: string, reportName: string) {
    const control = <FormArray>this.formModel.controls['medicalTestReports'];
    control.push(this.initMedicalTestReport(reportTemplateUuid, reportName));
    this.searchInput.setValue("");
  }

  onAddReportFinished() {

    this.popupBundleSubject.next({
      title: '请确认',
      body: '确认提交化验申请表单么?',
      hasCancelButton: true,
      hasConfirmButton: true,
      confirmButtonText: "确定",
      cancelButtonText: "取消"
    })
  }

  getMedicalTestReportStatus(medicalTestReport: any) {
    return ReportStatusEnum[medicalTestReport.reportStatus];
  }

  removeMedicalTestReport(i: number) {
    const control = <FormArray>this.formModel.controls['medicalTestReports'];
    control.removeAt(i);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pet'] && this.pet)
      this.formModel.controls['petUuid'].setValue(this.pet.uuid);
    if (changes['petOwner'] && this.petOwner)
      this.formModel.controls['petOwnerUuid'].setValue(this.petOwner.uuid);
  }

  onModalClosed($event: any) {
    let data=this.formModel.value;
    this.searchInput.setValue("");
    this.formModel.controls['medicalTestReports']=this.fb.array([], this.minLengthArray(1));
    this.generateMedicalTestReport.emit(data);
  }

  private initFormModel() {
    this.formModel = this.fb.group({
      'id': [''],
      'petOwnerUuid': ['', Validators.required],
      'petUuid': ['', Validators.required],
      'treatmentCaseUuid': [this.treatmentCaseUuid],
      'medicalTestReports': this.fb.array([], this.minLengthArray(1)),
    })
  }

  private initMedicalTestReport(reportTemplateUuid: string, reportName: string) {
    return this.fb.group({
      'reportTemplateUuid': [reportTemplateUuid, Validators.required],
      'reportName': [reportName, Validators.required],
    })
  }
}
