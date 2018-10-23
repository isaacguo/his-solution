import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {ViewModeEnum} from "../../../core/enums/view-mode.enum";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-management-container',
  templateUrl: './employee-management-container.component.html',
  styleUrls: ['./employee-management-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementContainerComponent implements OnInit {

  constructor(private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
  }

  onViewChanged(event: ViewModeEnum) {
    this.router.navigate([event?'list':'tree'], {relativeTo: this.route});
  }
}
