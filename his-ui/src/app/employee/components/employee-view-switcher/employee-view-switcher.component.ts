import {ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ViewModeEnum} from "../../../core/enums/view-mode.enum";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-view-switcher',
  templateUrl: './employee-view-switcher.component.html',
  styleUrls: ['./employee-view-switcher.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeViewSwitcherComponent implements OnInit {


  @Output()
  viewChanged = new EventEmitter<ViewModeEnum>()

  viewMode = ViewModeEnum.Tree;

  constructor(
    private router: Router,
    private route: ActivatedRoute) {
    this.route.firstChild.url.subscribe(r => {
      if (r[0].path === "tree") {
        this.viewMode=ViewModeEnum.Tree;
      }
      else {
        this.viewMode=ViewModeEnum.List;
      }
    });
  }

  ngOnInit() {

  }

  isViewModeList(): boolean {
    return this.viewMode === ViewModeEnum.List;
  }

  onSwitched(event) {
    this.viewChanged.emit(event ? ViewModeEnum.List : ViewModeEnum.Tree);
  }

}
