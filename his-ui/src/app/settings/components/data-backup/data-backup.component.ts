import {
  ChangeDetectionStrategy,
  Component, EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-data-backup',
  templateUrl: './data-backup.component.html',
  styleUrls: ['./data-backup.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class DataBackupComponent implements OnInit, OnChanges {

  @Input()
  pageData: any;

  @Input()
  scheduleInfo: any;

  @Output()
  scheduleInfoUpdated=new EventEmitter<any>();

  @ViewChild("scheduleBackupModal")
  scheduleBackupModal: ModalComponent;

  formModel: FormGroup;


  getHoursArr() {
    return Array.from(Array(24).keys()).map(i => i + 1);
  }

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder) {

    this.formModel = this.fb.group({
      'scheduleType': ['', Validators.required],
      'hourValue': ['1', Validators.required]
    })
  }


  ngOnInit() {
  }


  onPageChanged($event) {

  }

  onHourClicked(hour: string) {
    this.formModel.controls['hourValue'].setValue(hour);
  }

  onScheduleBackupClicked() {
    this.scheduleBackupModal.open();
  }

  onScheduleBackupClosed() {
    this.scheduleInfoUpdated.emit(this.formModel.value);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['scheduleInfo'] && this.scheduleInfo)
      this.formModel.patchValue(this.scheduleInfo);
  }
}
