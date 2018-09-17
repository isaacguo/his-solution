import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Tab} from "../../ui-controls/tabs/tab.model";
import {TreatmentCaseComment} from "../../treatment/models/treatment-comment.model";
import {TreatmentCase} from "../../treatment/models/treatment-case.model";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  @Input()
  treatmentCases: Observable<TreatmentCase[]>;
  @Input()
  treatmentCaseComments: Observable<TreatmentCaseComment[]>;
  @Input()
  selectedTreatmentCase: Observable<TreatmentCase>;

  @Input() tabs: Tab[];
  @Input() activeTab: Tab;
  @Output() outActivateTab = new EventEmitter<Tab>();

  @Output()
  treatmentCaseSelectedEvent = new EventEmitter<string>();
  @Output()
  createCommentEvent = new EventEmitter<TreatmentCaseComment>();

  constructor() {
  }

  ngOnInit() {
  }


  onTreatmentCaseSelectedEvent(event: any) {
    this.treatmentCaseSelectedEvent.emit({...event});
  }

  onCreateCommentEvent(event: TreatmentCaseComment) {
    this.createCommentEvent.emit({...event});

  }
}
