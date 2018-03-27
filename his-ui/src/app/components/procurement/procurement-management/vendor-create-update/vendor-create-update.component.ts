import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";

@Component({
  selector: 'app-vendor-create-update',
  templateUrl: './vendor-create-update.component.html',
  styleUrls: ['./vendor-create-update.component.css']
})
export class VendorCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  id: number;

  constructor(public router: Router, public route: ActivatedRoute) {
    super(route);
  }

  ngOnInit() {
    this.process();
  }
}
