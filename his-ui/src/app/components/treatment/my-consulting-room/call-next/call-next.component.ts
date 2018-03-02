import { Component, OnInit } from '@angular/core';
import {DepartmentService} from "../../../../services/treatment/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Department} from "../../../../dto/department.model";
import {TreatmentCase} from "../../../../dto/treatment-case.model";

@Component({
  selector: 'call-next',
  templateUrl: './call-next.component.html',
  styleUrls: ['./call-next.component.css']
})
export class CallNextComponent implements OnInit {


  department:Department;
  todayTreatmentCases:TreatmentCase[]=[];

  constructor(private departmentService: DepartmentService, private router: Router, private route: ActivatedRoute ) {

  }


  ngOnInit() {
  }
}
