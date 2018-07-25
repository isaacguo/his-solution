import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../../services/finance/finance-price.service";
import {FinanceChargeService} from "../../../../services/finance/finance-charge.service";
import {ChargeStatusEnum} from "../../../../enums/charge-status.enum";
import {TreatmentCaseService} from "../../../../services/treatment/treatment-case.service";
import {PetService} from "../../../../services/treatment/pet.service";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {


  chargeItems: any[] = [];

  constructor(private financeChargeService: FinanceChargeService,
              private treatmentCaseService: TreatmentCaseService,
              private petService: PetService) {

  }

  loadData() {
    this.financeChargeService.readAll().mergeMap(arr => {

      return this.petService.findByUuids(arr.map(each => ({"uuid": each.petUuid}))).map(retArr => ({
        'arr': arr,
        'uuidMap': retArr
      }))
    }).subscribe(r => {
      console.log(r);
      let nameMap: Map<string, { 'petName': string, 'petOwnerName': string }> = new Map<string, { 'petName': string, 'petOwnerName': string }>();
      r.uuidMap.forEach(um => nameMap.set(um.petUuid, {'petName': um.petName, 'petOwnerName': um.petOwnerName}));
      r.arr.forEach(item => {
        item.petName = (nameMap.get(item.petUuid) || {})['petName'];
        item.petOwnerName = (nameMap.get(item.petUuid) || {})['petOwnerName'];
      })

      this.chargeItems=r.arr;
    })

  }

  ngOnInit(): void {
    this.loadData();

  }

  getStatusText(status: any): string {
    return ChargeStatusEnum[status];
  }

}
