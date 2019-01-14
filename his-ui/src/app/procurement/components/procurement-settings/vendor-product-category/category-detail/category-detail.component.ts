import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {DepartmentListItem} from "../../../../../core/models/employee/department-list-item.model";

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent implements OnInit {



  @Input()
  departmentList: DepartmentListItem[];
  @Input()
  categoryId:number;

  constructor() { }

  ngOnInit() {
  }

}
