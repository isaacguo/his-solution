import { Component, OnInit } from '@angular/core';
import {FactoryResetService} from "../../../services/settings/factory-reset.service";

@Component({
  selector: 'app-factory-reset',
  templateUrl: './factory-reset.component.html',
  styleUrls: ['./factory-reset.component.css']
})
export class FactoryResetComponent implements OnInit {

  constructor(private factoryResetService:FactoryResetService) { }
  serviceArray: [string, string][] = [];

  ngOnInit() {
    this.loadData();
  }

  private loadData() {

    this.serviceArray=this.factoryResetService.serviceArray;
  }

  onResetButtonClicked(serviceUrl:string) {

    this.factoryResetService.resetService(serviceUrl).subscribe(r=>{});

  }

  onFillDemoDataButtonClicked(serviceUrl:string) {
    this.factoryResetService.fillDemoData(serviceUrl).subscribe(r=>{});
  }
}
