import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Observable} from "rxjs/Observable";
import {AbstractCreateUpdateComponent} from "../../../../shared/abstract-create-update.component";
import {Vendor} from "../../../models/vendor.model";
import {VendorProduct} from "../../../models/vendor-product.model";
import {OperationEnum} from "../../../../core/enums/operation.enum";
import {ProcurementRequestService} from "../../../../core/services/procurement/procurement-request.service";
import {VendorService} from "../../../../core/services/procurement/vendor.service";
import {Contact} from "../../../models/contact.model";

@Component({
  selector: 'app-procurement-request-create-update',
  templateUrl: './procurement-request-create-update.component.html',
  styleUrls: ['./procurement-request-create-update.component.css']
})
export class ProcurementRequestCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("confirmCreateModal")
  confirmCreateModal: ModalComponent;
  vendors:Vendor[]=[];
  selectedVendor:Vendor=null;

  formModel: FormGroup;
  searchInput: FormControl = new FormControl('');
  requestCreationResultText: string;

  vendorProducts:VendorProduct[]=[];




  getOperationText() {
    return this.operation === OperationEnum.CREATE ? "创建" : "修改";
  }

  constructor(public router: Router,
              public route: ActivatedRoute,
              private fb: FormBuilder,
              private procurementRequestService: ProcurementRequestService,
              private vendorService:VendorService) {
    super(route);

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          //return this.employeeService.findEmployeesByNameContains(name);
        }
      })
      .subscribe(r => {
        //this.employees = r;
      })
  }
  stopPropagation($event) {
    event.stopPropagation()
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'vendorInfo': this.fb.group({
        'vendorId':['',Validators.required],
        'vendor': ['', Validators.required],
        'contact': ['', Validators.required],
      }),
      'goods': this.fb.array([
        this.initGood()
      ]),
      'explanation': ['', Validators.required],
    })
  }

  initGood() {
    return this.fb.group({
      //'name': ['', Validators.required],
      'packageSpecification': ['', Validators.required],
      'packageUnit': ['', Validators.required],
      'number': ['0', [Validators.required, Validators.pattern(/^-?\d*(\.\d+)?$/)]],
    })
  }

  get goodsData() {
    return <FormArray>this.formModel.get('goods');
  }

  get vendorInfo() {
    return <FormGroup>this.formModel.get('vendorInfo');
  }

  addGood() {
    // add address to the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.push(this.initGood());
  }

  removeGood(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.removeAt(i);
    this.calculatePurchaseTotalPrice();
  }


  invokeWhenCreate() {
    this.procurementRequestService.createRequest(this.formModel.value).subscribe(r => {
      if (r === true) {
        this.requestCreationResultText = "采购申请单提交成功";
        this.confirmCreateModal.open();
      }
      else {
        console.log("false");
      }
    });
  }

  onConfirmCreateModalClosed() {
    this.router.navigate(['procurement-purchase', 'list']);
  }

  invokeWhenUpdate() {
  }

  onValueChanged(i: number) {
    this.calculatePriceForGood(i);
  }

  private calculatePriceForGood(i: number) {
    const goods = <FormArray>this.formModel.controls['goods'];
    const good = <FormGroup>goods.at(i);
    const number = <FormControl>good.controls['number'];
    const pricePerUnit = <FormControl>good.controls['pricePerUnit'];
    const totalPrice = <FormControl>good.controls['totalPrice'];
    if (number.value != null && pricePerUnit.value != null)
      totalPrice.setValue( this.roundTo(Number(number.value) * Number(pricePerUnit.value), 2));

    this.calculatePurchaseTotalPrice();
  }

  private roundTo(n, digits):number {
    var negative = false;
    if (digits === undefined) {
      digits = 0;
    }
    if( n < 0) {
      negative = true;
      n = n * -1;
    }
    var multiplicator = Math.pow(10, digits);
    n = parseFloat((n * multiplicator).toFixed(11));
    n = (Math.round(n) / multiplicator).toFixed(2);
    if( negative ) {
      n = (n * -1).toFixed(2);
    }
    return n;
  }

  private calculatePurchaseTotalPrice() {
    const totalPrice = <FormControl>this.formModel.controls['totalPrice'];
    let total:number = 0;
    const goods = <FormArray>this.formModel.controls['goods'];
    goods.controls.forEach(r => {
      const good = <FormGroup>r;
      const totalPrice = <FormControl>good.controls['totalPrice'];
      if (totalPrice.value != null)
        total += Number(totalPrice.value);
    })

    totalPrice.setValue(total);
  }


  ngOnInit() {
    this.initForm();

    this.process();
    this.vendorService.getPermittedVendors().subscribe(r=>{
      this.vendors=r;
    })
  }

  onVendorDropdownClicked(vendor: Vendor) {
    this.selectedVendor=vendor;
    this.formModel.get('vendorInfo').get('vendor').setValue(vendor.name);
    this.formModel.get('vendorInfo').get('vendorId').setValue(vendor.id);
    this.formModel.get('vendorInfo').get('contact').setValue("");
  }

  isVendorSelected():boolean {
    return this.selectedVendor!=null?true:false;
  }

  onContactDropdownClicked(contact: Contact) {
    this.formModel.get('vendorInfo').get('contact').setValue(contact.name);
  }


}
