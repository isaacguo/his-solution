import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";
import {Procurement} from "../../../models/procurement.model";
import {ProcurementOperationRequest} from "../../../models/procurement-operation-request.model";
import {ProcurementService} from "../../../../core/services/procurement/procurement.service";
import {ProcurementStatusService} from "../../../../core/services/procurement/procurement-status.service";
import {OperationEnum} from "../../../../core/enums/operation.enum";

@Component({
  selector: 'app-procurement-purchase-list',
  templateUrl: './procurement-purchase-list.component.html',
  styleUrls: ['./procurement-purchase-list.component.css']
})
export class ProcurementPurchaseListComponent implements OnInit {

  loading: boolean;
  procurements: Procurement[];
  selectedProcurement: Procurement;
  direction: string = 'vertical';
  startDate: any;
  endDate: any;
  query: ProcurementOperationRequest = {};

  flatenP: string[] = [];

  public myDatePickerOptions: IMyDpOptions = {
    // other options...
    dateFormat: 'yyyy-mm-dd',
  };


  constructor(private router: Router, private procurementService: ProcurementService, private procurementStatusService: ProcurementStatusService) {
  }

  ngOnInit() {

    this.loadData();
  }

  private loadData() {
    this.procurementStatusService.refresh();
    this.flatenP = this.procurementStatusService.flatenP;

    this.procurementService.getMyProcurements().subscribe(r => {
      this.procurements = r
    });
  }

  onCreateNewRequestButtonClicked() {
    this.router.navigate(['procurement-purchase', OperationEnum.CREATE]);
  }

  onUpdateButtonClicked(procurement: Procurement) {
    this.router.navigate(['procurement-purchase', OperationEnum.UPDATE, procurement.id]);
  }

  onRowClicked(procurement: Procurement) {
    this.selectedProcurement = procurement;
  }

  isRowSelected(procurement: Procurement): boolean {
    return this.selectedProcurement == procurement;
  }

  onStatusDropdownClicked(status: string) {
    this.query.status = status;
  }

  getTotalPrice() {
    let total: number = 0;
    if (this.procurements != null && this.procurements.length > 0)
      this.procurements.forEach(r => {
        total += Number(r.procurementRequest.totalPrice);
      })
    return total;
  }

  onClearButtonClicked() {
    this.query.status = "";
    this.query.vendor = "";
    this.query.startDate = "";
    this.query.endDate = "";
  }

  onSearchButtonClicked() {
    const p = new ProcurementOperationRequest();
    if (this.startDate != null)
      this.query.startDate = this.startDate.formatted;
    if (this.endDate != null)
      this.query.endDate = this.endDate.formatted;

    this.procurementService.findByQuery(this.query).subscribe(r => {
      this.procurements = r;
    });
  }

  onRefreshIconClicked() {

    this.loadData();
  }

  getStatus() {

    if (!this.loading)
      return "pull-right fa fa-refresh fa-fw isaac-margin-10bottom";
    else
      return "pull-right fa fa-refresh fa-spin fa-fw isaac-margin-10bottom";
  }


  onDateChanged1(event: IMyDateModel) {
    if (event.formatted !== '') {
      this.query.startDate = event.formatted;
    }
    else {
      this.query.startDate = '';
    }
  }

  onDateChanged2(event: IMyDateModel) {
    if (event.formatted !== '') {
      this.query.endDate = event.formatted;
    }
    else {
      this.query.endDate = '';
    }
  }
}

