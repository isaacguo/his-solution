import {Component, OnInit} from '@angular/core';
import {GuardFactoryService} from "./core/services/guard-factory.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  constructor(private guardFactoryService: GuardFactoryService) {

    this.guardFactoryService.addGuard("Employee", "员工管理", "操作");
    this.guardFactoryService.addGuard("Finance", "收费定价", "操作");
    this.guardFactoryService.addGuard("Finance", "财务管理", "操作");
    this.guardFactoryService.addGuard("Finance", "收费定价", "操作");
    this.guardFactoryService.addGuard("Medicine", "库房管理", "操作");
    this.guardFactoryService.addGuard("MedicalTest", "化验管理", "操作");
    this.guardFactoryService.addGuard("Medicine", "药房管理", "操作");
    this.guardFactoryService.addGuard("Procurement", "采购审批", "操作");
    this.guardFactoryService.addGuard("Procurement", "采购管理", "操作");
    this.guardFactoryService.addGuard("Treatment", "前台服务", "操作");
    this.guardFactoryService.addGuard("Treatment", "住院管理", "操作");
    this.guardFactoryService.addGuard("Treatment", "我的诊室", "操作");
    this.guardFactoryService.addGuard("Treatment", "就诊设置", "操作");
  }


  ngOnInit(): void {


  }
}
