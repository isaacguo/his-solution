import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-daily-management',
  templateUrl: './daily-management.component.html',
  styleUrls: ['./daily-management.component.css']
})
export class DailyManagementComponent implements OnInit {
  @Input()
  careRecords:any[];

  constructor() { }

  ngOnInit() {
  }

}
