import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from "../../../core/services/common/authorization.service";
import {FactoryResetService} from "../../../core/services/settings/factory-reset.service";

@Component({
  selector: 'app-factory-reset-container',
  templateUrl: './factory-reset-container.component.html',
  styleUrls: ['./factory-reset-container.component.css']
})
export class FactoryResetContainerComponent implements OnInit {

  constructor(private factoryResetService:FactoryResetService, public authorizationService:AuthorizationService) { }
  serviceArray: [string, string][] = [];

  ngOnInit() {
    this.loadData();
  }

  private loadData() {

    this.serviceArray=this.authorizationService.authorizationArray;
  }

  onResetButtonClicked(serviceUrl:string) {

    this.factoryResetService.resetService(serviceUrl).subscribe(r=>{});

  }

  onFillDemoDataButtonClicked(serviceUrl:string) {
    this.factoryResetService.fillDemoData(serviceUrl).subscribe(r=>{});
  }

}
