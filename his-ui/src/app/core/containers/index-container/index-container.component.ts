import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee/employee.service";
import {AuthenticationService} from "../../services/common/authentication.service";
import {Observable} from "rxjs/Observable";
import {GuardDelegation} from "../../guards/guard-delegation";
import {GuardFactoryService} from "../../services/guard-factory.service";

@Component({
  selector: 'app-index-container',
  templateUrl: './index-container.component.html',
  styleUrls: ['./index-container.component.css']
})
export class IndexContainerComponent implements OnInit {

  displayName$: Observable<string>;
  observableGuardMap$: Observable<Map<string, GuardDelegation>>;

  constructor(
    private authenticationService: AuthenticationService,
    private employeeService: EmployeeService,
    private guardFactoryService: GuardFactoryService
  ) {

    this.observableGuardMap$ = guardFactoryService.getObservableGuardsMap();
    this.displayName$ = authenticationService.authChange
      .mergeMap(() => this.employeeService.getMyInfo()).map(r => r.fullName);
  }

  ngOnInit() {
  }

}
