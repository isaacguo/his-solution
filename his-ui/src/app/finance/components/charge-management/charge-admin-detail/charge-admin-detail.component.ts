import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-charge-admin-detail',
  templateUrl: './charge-admin-detail.component.html',
  styleUrls: ['./charge-admin-detail.component.css']
})
export class ChargeAdminDetailComponent implements OnInit {

  @Input()
  nodes: any[];
  @Input()
  chargeCategoryId: number;

  constructor() {
  }

  ngOnInit() {
  }

}
