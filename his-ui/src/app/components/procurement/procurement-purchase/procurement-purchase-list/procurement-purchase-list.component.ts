import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ProcurementService} from "../../../../services/procurement/procurement.service";
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {OperationEnum} from "../../../../enums/operation.enum";

@Component({
  selector: 'app-procurement-purchase-list',
  templateUrl: './procurement-purchase-list.component.html',
  styleUrls: ['./procurement-purchase-list.component.css']
})
export class ProcurementPurchaseListComponent implements OnInit {

  procurements: Procurement[];
  selectedProcurement: Procurement;
  direction: string = 'vertical';


  constructor(private router: Router, private procurementService: ProcurementService ) {
  }

  ngOnInit() {
    this.procurementService.getMyProcurementsByAssignedPurchaseUrl().subscribe(r => {
      this.procurements = r
    });
  }

  onUpdateButtonClicked(procurement: Procurement) {
      this.router.navigate(['procurement-purchase', OperationEnum.UPDATE, procurement.id]);
  }

  onRowClicked(procurement:Procurement)
  {
    this.selectedProcurement=procurement;
  }

  isRowSelected(procurement: Procurement): boolean {
    return this.selectedProcurement == procurement;
  }


}
