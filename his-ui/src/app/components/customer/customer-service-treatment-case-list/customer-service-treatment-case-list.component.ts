import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Tab} from "../../../ui-controls/tabs/tab.model";
import {TreatmentCaseComment} from "../../../core/models/treatment/treatment-comment.model";
import {TreatmentCase} from "../../../core/models/treatment/treatment-case.model";

@Component({
  selector: 'app-customer-service-treatment-case-list',
  templateUrl: './customer-service-treatment-case-list.component.html',
  styleUrls: ['./customer-service-treatment-case-list.component.css']
})
export class CustomerServiceTreatmentCaseListComponent implements OnInit {

  @Input()
  filteredTreatmentCases: TreatmentCase[];
  @Input()
  treatmentCaseComments: Observable<TreatmentCaseComment[]>;
  @Input()
  selectedTreatmentCase: TreatmentCase;

  @Input() tabs: Tab[];


  @Output() updateCommentEvent = new EventEmitter<any>();
  @Output() createCommentEvent = new EventEmitter<TreatmentCaseComment>();
  @Output()
  treatmentCaseSelectedEvent = new EventEmitter<any>();


  constructor() {
  }

  ngOnInit() {
  }

  onCreateComment(event: any) {
    this.createCommentEvent.emit({...event, treatmentCaseUuid:this.selectedTreatmentCase.uuid});
  }

  onUpdateComment(event: any) {

  }

  onRowClicked(treatmentCase: any) {
    this.treatmentCaseSelectedEvent.emit(treatmentCase);
  }

  isRowSelected(treatmentCase: any) {
    return treatmentCase === this.selectedTreatmentCase;
  }
}
