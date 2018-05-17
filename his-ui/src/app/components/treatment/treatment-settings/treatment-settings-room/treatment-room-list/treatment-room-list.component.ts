import { Component, OnInit } from '@angular/core';
import {MyTreeNode} from "../../../../../dto/procurement/MyTreeNode";
import {DepartmentService} from "../../../../../services/treatment/department.service";

@Component({
  selector: 'app-treatment-room-list',
  templateUrl: './treatment-room-list.component.html',
  styleUrls: ['./treatment-room-list.component.css']
})
export class TreatmentRoomListComponent implements OnInit {

  constructor(public departmentService:DepartmentService) { }

  nodes: MyTreeNode[] = [];
  selectedRoomId: number;


  ngOnInit() {
  }

  loadData()
  {
    this.departmentService.getDepartments().subscribe(r=>{
    });
  }


  onNodeActivated($event) {
    //this.getSelectedNodeName();
  }
}
