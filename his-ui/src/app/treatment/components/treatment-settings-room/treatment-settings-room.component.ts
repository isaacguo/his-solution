import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {AbstractCategoryTreeComponent} from "../../../shared/components/abstract-category-tree/abstract-category-tree.component";

@Component({
  selector: 'app-treatment-settings-room',
  templateUrl: './treatment-settings-room.component.html',
  styleUrls: ['./treatment-settings-room.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentSettingsRoomComponent extends AbstractCategoryTreeComponent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
