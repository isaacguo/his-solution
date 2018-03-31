import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";

@Component({
  selector: 'app-procurement-request-list',
  templateUrl: './procurement-request-list.component.html',
  styleUrls: ['./procurement-request-list.component.css']
})
export class ProcurementRequestListComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  onCreateNewRequestButtonClicked() {
    this.router.navigate(['procurement-request', OperationEnum.CREATE]);
  }
}
