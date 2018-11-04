import {ChangeDetectionStrategy, Component, EventEmitter, Output} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-show-backup-files-table',
  templateUrl: './show-backup-files-table.component.html',
  styleUrls: ['./show-backup-files-table.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ShowBackupFilesTableComponent extends AbstractItemSelectableTableComponent<string> {




  constructor() {
    super();
  }

  ngOnInit() {

  }


}
