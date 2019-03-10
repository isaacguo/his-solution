import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Employee} from "../../../core/models/employee/employee.model";
import {Observable} from "rxjs/Observable";
import {EmployeeService} from "../../../core/services/employee/employee.service";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-management-list-view-container',
  templateUrl: './employee-management-list-view-container.component.html',
  styleUrls: ['./employee-management-list-view-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementListViewContainerComponent implements OnInit {

  employeeListPageData: Observable<any>;

  constructor(private employeeService: EmployeeService,
              private router: Router,
              private route: ActivatedRoute) {

    this.employeeListPageData = this.employeeService.getPageDataAsObservable();

    this.employeeService.loadPageData({page: 0, size: 15});
  }

  ngOnInit() {

  }

  onEmployeeEdited(event) {

  }

  onPageChanged(event)
  {
    this.employeeService.loadPageData({page: event, size: 15});
  }


}
