import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {getPetGenderEnumArr, getRegistrationStatusArr} from "../../../utilities/enum-utilities";
import {PageableParams} from "../../../core/models/pageable-params.model";
import {RegistrationStatusEnum} from "../../../core/enums/registration-status.enum";

@Component({
  selector: 'app-registration-query',
  templateUrl: './registration-query.component.html',
  styleUrls: ['./registration-query.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class RegistrationQueryComponent implements OnInit {

  @Input()
  pageData: any;

  @Output()
  pageChanged = new EventEmitter<number>();
  @Output()
  statusChanged = new EventEmitter<PageableParams>();

  constructor() {
    this.pageData = [];
  }

  @Input()
  selectedStatusText: string;

  registrationStatusArr: [string, string][] = getRegistrationStatusArr();

  onStatusClicked(status: string) {
    this.statusChanged.emit({page: this.pageData.number, size: this.pageData.size, status: status});
  }


  ngOnInit() {
  }

  onPageChanged(event) {
    this.pageChanged.emit(event - 1);
  }
}
