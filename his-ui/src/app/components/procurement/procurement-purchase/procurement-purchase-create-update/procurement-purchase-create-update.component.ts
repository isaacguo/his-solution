import {Component, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {ProcurementRequestService} from "../../../../services/procurement/procurement-request.service";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ProcurementService} from "../../../../services/procurement/procurement.service";
import {Contact} from "../../../../dto/procurement/contact.model";
import {ProcurementPurchaseGood} from "../../../../dto/procurement/procurement-purchase-good.model";
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {ProcurementGoods} from "../../../../dto/procurement/procurement-goods.model";
import {VendorService} from "../../../../services/procurement/vendor.service";
import {Vendor} from "../../../../dto/procurement/vendor.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-procurement-purchase-create-update',
  templateUrl: './procurement-purchase-create-update.component.html',
  styleUrls: ['./procurement-purchase-create-update.component.css']
})
export class ProcurementPurchaseCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("vendorListModal")
  vendorListModal: ModalComponent;

  availableProcurementStatus: string[] = [];
  selectedStatus: string;

  procurement: Procurement;
  vendors: Vendor[];
  selectedVendor: Vendor;

  formModel: FormGroup;

  constructor(public router: Router,
              public route: ActivatedRoute,
              private fb: FormBuilder,
              private procurementService: ProcurementService,
              private vendorService: VendorService) {
    super(route);
  }

  ngOnInit() {
    this.initForm();
    this.process();
    this.vendorService.findAll().subscribe(r => {
      this.vendors = r;
    })
    this.formModel.controls['procurementId'].setValue(this.updateId);

    this.procurementService.findOneById(this.updateId).subscribe(r => {
      this.procurement = r;
    })
  }

  get goodsData() {
    return <FormArray>this.formModel.get('goods');
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'procurementId': [''],
      'goods': this.fb.array([]),
      'totalPrice': ['']
    })
  }

  private initGood() {
    return this.fb.group({
      'name': [''],
      'vendor': [''],
      'contact': [''],
      'contactTelephone': [''],
      'number': [''],
      'packageSpecification': [''],
      'packageUnit': [''],
      'otherRequirements': [''],
      'pricePerUnit': [''],
      'totalPrice': [''],
    })
  }

  invokeWhenCreate() {
  }

  invokeWhenUpdate() {
  }

  onSubmit() {

  }

  addGood() {
    // add good to the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.push(this.initGood());
  }

  removeGood(i: number) {
    // remove good from the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.removeAt(i);
  }

  inflateGood(good: ProcurementGoods) {
    const control = <FormArray>this.formModel.controls['goods'];

    control.push(this.fb.group({
      'name': [good.name],
      'vendor': [''],
      'contact': [''],
      'contactTelephone': [''],
      'number': [good.number],
      'packageSpecification': [good.packageSpecification],
      'packageUnit': [good.packageUnit, [Validators.required, Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'otherRequirements': [good.otherRequirements],
      'pricePerUnit': ['', [Validators.required, Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'totalPrice': ['', [Validators.required, Validators.pattern(/^-?\d*(\.\d+)?$/)]],
    }));
  }

  clearGoods() {
    const control = <FormArray>this.formModel.controls['goods'];
    control.controls = [];
  }

  onGenerateOrderButtonClicked() {
    this.procurement.procurementRequest.goods.forEach(r => {
      this.inflateGood(r);
    })
  }

  onSpecifyVendorButtonClicked() {
    this.vendorListModal.open();
  }

  onUnitChange(i: number) {
    this.calculatePriceForGood(i);
  }

  private calculatePriceForGood(i: number) {
    const goods = <FormArray>this.formModel.controls['goods'];
    const good = <FormGroup>goods.at(i);
    const number = <FormControl>good.controls['number'];
    const pricePerUnit = <FormControl>good.controls['pricePerUnit'];
    const totalPrice = <FormControl>good.controls['totalPrice'];
    if (number.value != null && pricePerUnit.value != null)
      totalPrice.setValue(<number>number.value * <number>pricePerUnit.value);

    this.calculatePurchaseTotalPrice();
  }

  private calculatePurchaseTotalPrice() {
    const totalPrice= <FormControl>this.formModel.controls['totalPrice'];
    let total=0;
    const goods = <FormArray>this.formModel.controls['goods'];
    goods.controls.forEach(r => {
      const good = <FormGroup>r;
      const number = <FormControl>good.controls['number'];
      const pricePerUnit = <FormControl>good.controls['pricePerUnit'];
      const totalPrice = <FormControl>good.controls['totalPrice'];
      if (totalPrice.value != null )
        total+=<number>totalPrice.value;
    })

    totalPrice.setValue(total);
  }

  onPerUnitChange(i: number) {
    this.calculatePriceForGood(i);
  }

  onVendorSelected(vendor: Vendor) {
    this.selectedVendor = vendor;

  }

  onVendorListModalModalClosed() {
    const goods = <FormArray>this.formModel.controls['goods'];

    goods.controls.forEach(r => {
      console.log(r);
      const good = <FormGroup>r;
      good.controls['vendor'].setValue(this.selectedVendor.name);
    })
  }
}
