import {Component, Input, OnInit} from '@angular/core';
import {DepartmentListItem} from "../../../../../dto/employee/department-list-item.model";

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
