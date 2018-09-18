import {Component, OnInit} from '@angular/core';
import {VendorGuard} from "../../guards/vendor.guard";

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
