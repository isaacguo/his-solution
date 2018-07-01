import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";

@Component({
  selector: 'app-query-bar',
  templateUrl: './query-bar.component.html',
  styleUrls: ['./query-bar.component.css']
})
export class QueryBarComponent implements OnInit {


  public searchFormModel: FormGroup;

  @Input()
  includeDone: boolean = false;
  @Output()
  includeDoneChanged: EventEmitter<boolean> = new EventEmitter();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initSearchFormModel();
  }

  private initSearchFormModel() {
    this.searchFormModel = this.fb.group({
      'memberId': [''],
      'treatmentId': [''],
      'ownerName': [''],
      'petName': [''],
      'mobilePhoneNumber': [''],
      'startDate': [''],
      'endDate': [''],
      'includeDone': [false]
    })
  }

  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  onDateChanged(control: string, event: IMyDateModel) {
    if (event.formatted !== '') {
      this.searchFormModel.controls[control].setValue(event.formatted);
    }
    else {
      this.searchFormModel.controls[control].setValue("");
    }
  }

  onIncludeDoneChanged(event) {
    this.includeDoneChanged.emit();
  }

}
