import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee/employee.service";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  employeeCount: number;

  constructor(private employeeService: EmployeeService) {


  }

  ngOnInit() {
    this.employeeService.getEmployeeCount().subscribe(r => {
      this.employeeCount = r.count;
    })

  }

}
