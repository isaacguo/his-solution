import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {TreatmentCaseService} from "../../../../../services/treatment/treatment-case.service";
import {Router} from "@angular/router";
import {MedicalTestReportService} from "../../../../../services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../../../services/medical-test/medical-test-report-template.service";
import {FormControl, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnChanges {


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  @Input()
  treatmentCase: any;
  detailedTreatmentCase: any[] = [];


  constructor(private router: Router,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private treatmentCaseService: TreatmentCaseService) {

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          return this.medicalTestReportTemplateService.findMedicalTestReportTemplateByNameContains(name);
        }
      })
      .subscribe(r => {
        this.medicalTestReportTemplates=r;
      })

  }

  private loadData() {
    if (this.treatmentCase != null)
      this.treatmentCaseService.readOne(this.treatmentCase.id).subscribe(r => {
        this.detailedTreatmentCase = r;
      });
  }

  onRequestMedicalTest() {



  }

  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  medicalTestReportTemplates:any[]=[];
  stopPropagation($event) {
    event.stopPropagation()
  }

  onChooseReportTypeModalClosed() {

  }

  selectedReportType: any;
  isRowSelected(report: any) {
    return this.selectedReportType === report;
  }

  onReportTypeSelected(report: any) {
    this.selectedReportType = report;
  }

  onMedicalTestReportTemplateSelected(medicalTestReportTemplate: any) {
    console.log(medicalTestReportTemplate);

  }
}
