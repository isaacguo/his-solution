import { Component, OnInit } from '@angular/core';
import {ProcurementApprovalService} from "../../../services/procurement/procurement-approval.service";
import {VendorGuard} from "../../../guards/procurement/vendor.guard";

@Component({
  selector: 'app-procurement-settings',
  templateUrl: './procurement-settings.component.html',
  styleUrls: ['./procurement-settings.component.css']
})
export class ProcurementSettingsComponent implements OnInit {



  constructor(private vendorGuard:VendorGuard) { }

  ngOnInit() {

  }

  canShowVendor():boolean {
    return this.vendorGuard.canActivate();
  }
}
