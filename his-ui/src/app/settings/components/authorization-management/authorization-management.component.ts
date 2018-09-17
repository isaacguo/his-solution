import {Component, OnInit} from '@angular/core';
import {Authorization} from "../../../core/models/authorization/authorization.model";
import {AuthorizationService} from "../../../core/services/common/authorization.service";

@Component({
  selector: 'app-authorization-management',
  templateUrl: './authorization-management.component.html',
  styleUrls: ['./authorization-management.component.css']
})
export class AuthorizationManagementComponent implements OnInit {

  keys: [string, string][] = [];
  assignmentMap: Map<[string, string], Authorization[]> = new Map<[string, string], Authorization[]>();

  constructor(private authorizationService: AuthorizationService) {

  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {

    this.authorizationService.authorizationArray.forEach((r, index) => {
      this.authorizationService.getAuthorizations(r[0]).subscribe(z => {
        this.assignmentMap.set(r, z);
        this.keys[index] = r;
      });
    });
  }
}
