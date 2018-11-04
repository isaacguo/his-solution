import {Component, OnInit} from '@angular/core';
import {DataManagementService} from "../../../core/services/gateway/data-management.service";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-data-backup-container',
  templateUrl: './data-backup-container.component.html',
  styleUrls: ['./data-backup-container.component.css']
})
export class DataBackupContainerComponent implements OnInit {

  infoChangedSubject = new BehaviorSubject<boolean>(false);
  infoChangedObject$ = this.infoChangedSubject.asObservable();
  scheduleInfo$: Observable<any>;
  backupFolders$: Observable<string[]>;

  backupFilesSubject = new BehaviorSubject<string[]>([]);
  backupFiles$ = this.backupFilesSubject.asObservable();

  constructor(private dataManagementService: DataManagementService) {
    this.scheduleInfo$ = this.infoChangedObject$.mergeMap(() => this.dataManagementService.readOne(1));
    this.backupFolders$ = this.infoChangedObject$.mergeMap(() => this.dataManagementService.getBackupFolders());
  }

  ngOnInit() {

  }


  onScheduleInfoUpdated($event) {
    this.dataManagementService.update(1, {...$event})
      .subscribe(() => this.infoChangedSubject.next(true));
  }

  onRestoreFolder($event: string) {
    this.dataManagementService.restoreFolder($event)
      .subscribe(() => this.infoChangedSubject.next(true));
  }

  onFolderReview($event: string) {
    this.dataManagementService.getBackupFiles($event).subscribe((files) => this.backupFilesSubject.next(files));
  }
}
