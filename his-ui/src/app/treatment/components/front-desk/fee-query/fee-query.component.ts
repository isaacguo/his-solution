import {Component, OnInit, ViewChild} from '@angular/core';
import {QueryBarComponent} from "../../../../shared/query-bar/query-bar.component";

@Component({
  selector: 'app-fee-query',
  templateUrl: './fee-query.component.html',
  styleUrls: ['./fee-query.component.css']
})
export class FeeQueryComponent implements OnInit {

  @ViewChild("searchBar")
  queryBarComponent: QueryBarComponent;

  constructor() {
  }


  ngOnInit() {
  }

}
