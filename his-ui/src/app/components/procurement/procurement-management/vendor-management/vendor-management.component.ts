import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";

@Component({
  selector: 'app-vendor-management',
  templateUrl: './vendor-management.component.html',
  styleUrls: ['./vendor-management.component.css']
})
export class VendorManagementComponent implements OnInit {

  constructor(public router: Router, public route: ActivatedRoute) {
  }

  ngOnInit() {
  }

  onCreateNewVendorClicked() {
    this.router.navigate(['procurement-settings','vendors',OperationEnum.CREATE]);
  }

  onUpdateVendorClicked() {
    this.router.navigate(['procurement-settings','vendors',OperationEnum.UPDATE,1]);
  }
}
