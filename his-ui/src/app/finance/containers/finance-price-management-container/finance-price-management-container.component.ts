import {Component, OnInit} from '@angular/core';
import {Tag} from "../../models/tag.model";
import {Observable} from "rxjs/Observable";
import {take} from "rxjs/operators";
import {ActivatedRoute, Router} from "@angular/router";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-finance-price-management-container',
  templateUrl: './finance-price-management-container.component.html',
  styleUrls: ['./finance-price-management-container.component.css']
})
export class FinancePriceManagementContainerComponent {

  selectedTag: Observable<Tag>;

  tags: Tag[] = [
    {id: 'treatment', title: '就诊模块'},
    {id: 'medical-test', title: '化验模块'},
    {id: 'inventory', title: '库房模块'},
  ];

  constructor(private router: Router,
              private route: ActivatedRoute,) {

    this.selectedTag = this.route.url.map(() => this.tags.find((tag) => router.isActive(`/finance/price-management/${tag.id}`, false)))
  }


  onTagSelected(tag: Tag) {
    this.router.navigate(['finance', 'price-management', tag.id]);
  }

}
