import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IMyDateModel, IMyDpOptions} from "mydatepicker";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-finace-query',
  templateUrl: './finace-query.component.html',
  styleUrls: ['./finace-query.component.css']
})
export class FinaceQueryComponent implements OnInit {


  public searchFormModel: FormGroup;

  @Output()
  includeDoneChanged: EventEmitter<boolean> = new EventEmitter();
  @Output()
  queryClicked: EventEmitter<boolean> = new EventEmitter();

  constructor(private fb: FormBuilder) {

  }

  ngOnInit() {
    this.initSearchFormModel();
  }

  private initSearchFormModel() {
    this.searchFormModel = this.fb.group({
      'chargeName': [''],
      'treatmentId': [''],
      'ownerName': [''],
      'petName': [''],
      'mobilePhoneNumber': [''],
      'startDate': [''],
      'endDate': [''],
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


  onQueryClicked()
  {
    this.queryClicked.emit();
  }


}
