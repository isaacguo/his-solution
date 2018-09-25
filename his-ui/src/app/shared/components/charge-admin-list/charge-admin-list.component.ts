import {Component, OnInit} from '@angular/core';
import {FinanceChargeService} from "../../../core/services/finance/finance-charge.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {ChargeStatusEnum} from "../../../finance/enums/charge-status.enum";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {


  chargeItems: any[] = [];

  constructor(private financeChargeService: FinanceChargeService,
              private petService: PetService) {

  }

  loadData() {
    this.financeChargeService.readAll().mergeMap(arr => {
      return this.petService.findByUuids(arr.map(each => ({"uuid": each.petUuid}))).map(retArr => ({
        'arr': arr,
        'uuidMap': retArr
      }))
    }).subscribe(r => {
      let nameMap: Map<string, { 'petName': string, 'petOwnerName': string }> = new Map<string, { 'petName': string, 'petOwnerName': string }>();
      r.uuidMap.forEach(um => nameMap.set(um.petUuid, {'petName': um.petName, 'petOwnerName': um.petOwnerName}));
      r.arr.forEach(item => {
        item.petName = (nameMap.get(item.petUuid) || {})['petName'];
        item.petOwnerName = (nameMap.get(item.petUuid) || {})['petOwnerName'];
      })

      this.chargeItems = r.arr;
    })

  }

  ngOnInit(): void {
    this.loadData();

  }

  getStatusText(status: any): string {
    return ChargeStatusEnum[status];
  }

  onPaidClicked(chargeItem: any) {
    this.financeChargeService.updateStatus(chargeItem.id, "PAID").subscribe(r => {
      this.loadData();
    });
  }

  onReimbursedClicked(chargeItem: any) {

  }

  isPaid(status: any):boolean {
    return this.getStatusText(status)===ChargeStatusEnum.PAID;

  }
}
