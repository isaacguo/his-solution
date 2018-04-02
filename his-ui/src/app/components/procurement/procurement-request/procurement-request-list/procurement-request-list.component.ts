import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";
import {ProcurementService} from "../../../../services/procurement/procurement.service";
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {Pet} from "../../../../dto/pet.model";
import {ProcurementApprovalService} from "../../../../services/procurement/procurement-approval.service";

@Component({
  selector: 'app-procurement-request-list',
  templateUrl: './procurement-request-list.component.html',
  styleUrls: ['./procurement-request-list.component.css']
})
export class ProcurementRequestListComponent implements OnInit {

  list: Procurement[];
  selectedProcurement: Procurement;


  constructor(private router: Router, private procurementService: ProcurementService ) {
  }

  ngOnInit() {
    this.procurementService.getMyProcurements().subscribe(r => {
      this.list = r
    });

  }

  onCreateNewRequestButtonClicked() {
    this.router.navigate(['procurement-request', OperationEnum.CREATE]);
  }

  onRowClicked(procurement: Procurement) {
    this.selectedProcurement = procurement;
  }

  isRowSelected(procurement: Procurement): boolean {
    return this.selectedProcurement == procurement;
  }
}
