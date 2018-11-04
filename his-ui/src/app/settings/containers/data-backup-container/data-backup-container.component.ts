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

  constructor(private dataManagementService: DataManagementService) {
    this.scheduleInfo$ = this.infoChangedObject$.mergeMap(() => this.dataManagementService.readOne(1));
  }

  ngOnInit() {

  }


  onScheduleInfoUpdated($event) {
    this.dataManagementService.update(1, {...$event})
      .subscribe(() => this.infoChangedSubject.next(true));
  }
}
