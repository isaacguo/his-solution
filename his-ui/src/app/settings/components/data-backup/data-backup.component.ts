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
import {Observable} from "rxjs/Observable";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-data-backup',
  templateUrl: './data-backup.component.html',
  styleUrls: ['./data-backup.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class DataBackupComponent implements OnInit, OnChanges {

  @Input()
  backupFolders: string[];
  @Input()
  backupFiles: string[];

  @Input()
  scheduleInfo: any;

  @Output()
  scheduleInfoUpdated = new EventEmitter<any>();

  @Output()
  restoreFolder = new EventEmitter<string>();
  @Output()
  folderReview = new EventEmitter<string>();


  @ViewChild("scheduleBackupModal")
  scheduleBackupModal: ModalComponent;

  @ViewChild("showBackupFilesModal")
  showBackupFilesModal: ModalComponent;


  formModel: FormGroup;
  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder) {

    this.formModel = this.fb.group({
      'scheduleType': ['', Validators.required],
      'hourValue': ['1', Validators.required]
    })
  }

  getHoursArr() {
    return Array.from(Array(24).keys()).map(i => i + 1);
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

  onRestoreFileClicked(file: string) {
    this.restoreFolder.emit(file);
  }

  onReviewFolder(folder: string) {
    this.folderReview.next(folder);

    this.showBackupFilesModal.open();
  }

  onShowBackupFilesModalClosed() {

  }


  onModalClosed($event) {
    this.restoreFolder.emit($event.folder);
  }

  onRestoreFolder(folder: string) {
    this.popupBundleSubject.next({
      title: '请确认',
      body: '<h4>确定要进行数据库恢复操作么？</h4> <br> <h4 class="label label-danger isaac-font-medium ">此操作将更新数据库，请慎重操作</h4> ',
      hasConfirmButton: true,
      hasCancelButton: true,
      confirmButtonText: "确定",
      cancelButtonText: "取消",
      payload: {folder: folder}
    })
  }
}
