import {Component, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-procurement-request-create-update',
  templateUrl: './procurement-request-create-update.component.html',
  styleUrls: ['./procurement-request-create-update.component.css']
})
export class ProcurementRequestCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  constructor(public router: Router, public route: ActivatedRoute) {
    super(route);
  }

  ngOnInit() {
  }

}
