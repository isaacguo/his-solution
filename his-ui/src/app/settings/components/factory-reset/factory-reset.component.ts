import {Component, OnInit} from '@angular/core';
import {FactoryResetService} from "../../../core/services/settings/factory-reset.service";
import {AuthorizationService} from "../../../core/services/common/authorization.service";

@Component({
  selector: 'app-factory-reset',
  templateUrl: './factory-reset.component.html',
  styleUrls: ['./factory-reset.component.css']
})
export class FactoryResetComponent implements OnInit {

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
