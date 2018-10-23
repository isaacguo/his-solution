import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from "../../../core/services/common/authorization.service";
import {Authorization} from "../../../core/models/authorization/authorization.model";

@Component({
  selector: 'app-authorization-container',
  templateUrl: './authorization-container.component.html',
  styleUrls: ['./authorization-container.component.css']
})
export class AuthorizationContainerComponent implements OnInit {

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
