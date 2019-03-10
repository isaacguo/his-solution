import {Component} from '@angular/core';
import {Tag} from "../../models/tag.model";
import {Observable} from "rxjs/Observable";
import {ActivatedRoute, Router} from "@angular/router";
import "rxjs/add/operator/map";

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

    this.router.navigate(['finance', 'price-management', this.tags[0].id]);
  }


  onTagSelected(tag: Tag) {
    this.router.navigate(['finance', 'price-management', tag.id]);
  }

}
