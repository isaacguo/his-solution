import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OperationEnum} from "../../../../enums/operation.enum";
import {VendorService} from "../../../../services/business/procurement/vendor.service";
import {Contact} from "../../../../dto/procurement/contact.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-vendor-create-update',
  templateUrl: './vendor-create-update.component.html',
  styleUrls: ['./vendor-create-update.component.css']
})
export class VendorCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  formModel: FormGroup;

  vendorCreationResultText: string;
  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;


  getOperationText() {
    return this.operation === OperationEnum.CREATE ? "创建" : "修改";
  }

  constructor(public router: Router, public route: ActivatedRoute, private fb: FormBuilder, private vendorService: VendorService) {
    super(route);

  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'name': ['', [Validators.required]],
      'contacts': this.fb.array([
        this.initContacts()
      ]),
      'description': [''],
      'address': [''],
      'postcode': [''],
      'officialWebsiteLink': [''],
      'email': [''],
    })
  }

  get contactsData() {
    return <FormArray>this.formModel.get('contacts');
  }

  initContacts() {
    return this.fb.group({
      'name': ['', Validators.required],
      'telephone': ['', Validators.required],
      'id': ['']
    })
  }

  ngOnInit() {

    this.initForm();

    this.process();

    if (this.operation === OperationEnum.UPDATE) {
      this.vendorService.findById(this.updateId).subscribe(r => {
        this.inflatFormModelWithValues(r);
        this.clearContacts();
        r.contacts.forEach(contact => {
          this.inflateContact(contact);
        })
      })
    }
  }

  private inflatFormModelWithValues(r) {
    this.formModel.controls['name'].setValue(r.name);
    this.formModel.controls['address'].setValue(r.address);
    this.formModel.controls['postcode'].setValue(r.postcode);
    this.formModel.controls['description'].setValue(r.description);
    this.formModel.controls['officialWebsiteLink'].setValue(r.officialWebsiteLink);
    this.formModel.controls['email'].setValue(r.email);
    this.formModel.controls['id'].setValue(r.id);
    this.formModel.controls['postcode'].setValue(r.postcode);
  }

  clearContacts() {
    const control = <FormArray>this.formModel.controls['contacts'];
    control.controls = [];
  }

  inflateContact(contact: Contact) {
    const control = <FormArray>this.formModel.controls['contacts'];

    control.push(this.fb.group({
      'name': [contact.name, Validators.required],
      'telephone': [contact.telephone, Validators.required],
      'id': [contact.id]
    }));
  }

  addContact() {
    // add address to the list
    const control = <FormArray>this.formModel.controls['contacts'];
    control.push(this.initContacts());
  }

  removeContact(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['contacts'];
    control.removeAt(i);
  }

  onSubmit() {
    if (this.operation === OperationEnum.CREATE) {
      this.vendorService.createVendor(this.formModel.value).subscribe(r => {
        if (r.id > 0) {
          this.vendorCreationResultText = "供应商信息添加成功";
          this.confirmCreateModal.open();
        }
      });
    }
    else {
      this.vendorService.updateVendor(this.formModel.value).subscribe(r=>{
        if (r.id > 0) {
          this.vendorCreationResultText = "供应商信息更新成功";
          this.confirmCreateModal.open();
        }
      },error=>{
        console.log(error);
      })

    }

  }

  onConfirmCreateModalClosed() {
    this.router.navigate(['procurement-settings', 'vendors']);
  }
}
