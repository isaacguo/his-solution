import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-data-backup',
  templateUrl: './data-backup.component.html',
  styleUrls: ['./data-backup.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class DataBackupComponent implements OnInit {

  @Input()
  pageData: any;

  selectedStatusText: string = '1';

  getHoursArr() {
    return Array.from(Array(23).keys()).map(i => i + 1);
  }
  constructor() {
  }

  ngOnInit() {
  }


  onPageChanged($event)
  {

  }
}
