import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {FinancePriceService} from "../../../../../services/finance/finance-price.service";
import {MedicalTestReportTemplate} from "../../../../../dto/medical-test/medical-test-report-template.model";
import {OperationEnum} from "../../../../../enums/operation.enum";
import {Router} from "@angular/router";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {InventoryCategoryService} from "../../../../../services/inventory/inventory-category.service";
import {InventoryItemService} from "../../../../../services/inventory/inventory-item.service";

@Component({
  selector: 'app-inventory-settings-item-management-detail',
  templateUrl: './inventory-settings-item-management-detail.component.html',
  styleUrls: ['./inventory-settings-item-management-detail.component.css']
})
export class InventorySettingsItemManagementDetailComponent implements OnInit, OnChanges {

  @Input()
  canCreateNewItem: boolean = true;
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  canShowAmount: boolean = false;
  @Input()
  financePriceService: FinancePriceService;


  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;

  @Input()
  categoryName: string;
  @Input()
  categoryId: number;

  constructor(
    public router: Router,
    private inventoryCategoryService: InventoryCategoryService,
    private inventoryItemService: InventoryItemService) {
  }

  ngOnInit() {
  }

  inventoryItemList: any[] = [];

  loadData() {

    if (this.categoryId !== undefined && this.categoryId !== null) {
      if (this.financePriceService !== undefined) {
        this.inventoryCategoryService.readOne(this.categoryId).mergeMap(category => {
          return this.financePriceService.findByUuids(category.inventoryItemList.map(m => m.uuid)).map(list => ({
            'category': category,
            'list': list
          }))
        })
          .subscribe(r => {

            r.list.forEach(b => {
                let item = r.category.reportTemplateList.find(r => r.uuid === b["priceItemUuid"]);
                if (item != null) {
                  item.normalPrice = b["normalPrice"];
                  item.memberPrice = b["memberPrice"];
                }
              }
            );
            this.inventoryItemList = r.category.inventoryItemList;
          })
      }
      else {

        this.inventoryCategoryService.readOne(this.categoryId).subscribe(r => {
          this.inventoryItemList = r.inventoryItemList;
        })
      }
    }

  }

  onCreateNewItemClicked() {
    this.router.navigate(['inventory-item', OperationEnum.CREATE, this.categoryId]);
  }


  onEditButtonClicked(report: MedicalTestReportTemplate) {
  }

  itemToBeDeleted: any;

  removeReport(item: any) {

    this.itemToBeDeleted = item;
    this.confirmDeletionModal.open();
  }

  onConfirmDeletionModalClosed() {
    this.inventoryItemService.deleteById(this.itemToBeDeleted.id).subscribe(r => {
      this.loadData();
    })
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }


  onValueChanged(event: number, report, fieldName: string) {
    //console.log(event);
    //console.log(report);
    let obj = {};
    obj[fieldName] = event;
    obj['uuid'] = report.uuid;
    this.financePriceService.updateValue(obj).subscribe(r => {

    });
  }

}
