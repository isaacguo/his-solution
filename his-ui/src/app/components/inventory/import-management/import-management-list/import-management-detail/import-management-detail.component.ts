import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-import-management-detail',
  templateUrl: './import-management-detail.component.html',
  styleUrls: ['./import-management-detail.component.css']
})
export class ImportManagementDetailComponent implements OnInit {

  @Input()
  importReceiptId:number;

  constructor() { }

  ngOnInit() {
  }

}
