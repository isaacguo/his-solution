import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";
import {Vendor} from "../../../../dto/procurement/vendor.model";
import {VendorService} from "../../../../services/procurement/vendor.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {DepartmentListItem} from "../../../../dto/employee/department-list-item.model";
import {VendorCategoryService} from "../../../../services/procurement/vendor-category.service";
import {VendorCategory} from "../../../../dto/procurement/vendor-category.model";
import {VendorPermitDepartment} from "../../../../dto/employee/vendor-permit-department.model";

@Component({
  selector: 'app-vendor-management',
  templateUrl: './vendor-management.component.html',
  styleUrls: ['./vendor-management.component.css']
})
export class VendorManagementComponent implements OnInit, OnChanges {
  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  @Input()
  departmentList: DepartmentListItem[];
  @Input()
  categoryId: number;

  isModified:boolean=false;

  @ViewChild("deleteResultModal") deleteResultModal: ModalComponent;
  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;

  deleteResultText: string;
  vendorToBeDeleted: Vendor;

  searchInput: FormControl = new FormControl('');

  vendors: Vendor[];
  vendorCategory: VendorCategory;

  constructor(public router: Router, public route: ActivatedRoute,
              private vendorService: VendorService,
              private vendorCategoryService: VendorCategoryService) {

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {
        if (name === "") return this.vendorService.findAll()
        else
          return this.vendorService.findByNameContains(name);
      })
      .subscribe(r => {
        this.vendors = r;
      })
  }

  ngOnInit() {

    console.log(this.categoryId);
    this.loadData();
  }

  loadData() {
    if (this.categoryId != undefined)
      this.vendorCategoryService.findVendorCategoryById(this.categoryId).subscribe(r => {
        this.vendorCategory = r;

        this.departmentList.forEach(r => {
          if (this.vendorCategory.departments.findIndex(d => d.departmentId === r.id) == -1) {
            let vpd = new VendorPermitDepartment();
            vpd.permitted = false;
            vpd.departmentName = r.name;
            vpd.departmentId = r.id;
            this.vendorCategory.departments.push(vpd);
          }
        });
      })
  }

  onCreateNewVendorClicked() {
    this.router.navigate(['procurement-settings', 'vendors', OperationEnum.CREATE]);
  }


  onModifyVendorButtonClicked(vendor: Vendor) {

    this.router.navigate(['procurement-settings', 'vendors', OperationEnum.UPDATE, vendor.id]);

  }

  onRemoveVendorButtonClicked(vendor: Vendor) {

    this.vendorToBeDeleted = vendor;
    this.confirmDeletionModal.open();
  }

  onConfirmDeletionModalClosed() {

    this.vendorService.deleteVendor(this.vendorToBeDeleted).subscribe(r => {

      if (r == true) {
        this.loadData();
        this.deleteResultText = "供应商信息删除成功";
        this.deleteResultModal.open();
      }
      else {
        this.deleteResultText = "供应商信息删除失败";
        this.deleteResultModal.open();
      }
    })
  }

  onChange(dep: DepartmentListItem, event) {
    this.isModified=true;
    let department = this.vendorCategory.departments.find(r => r.departmentId === dep.id);
    if(department!=null)
      department.permitted=event;
  }

  onUpdatePermissionButtonClicked() {

    this.vendorCategoryService.updateDepartmentPermission(this.vendorCategory.id, this.vendorCategory.departments).subscribe(r=>{

      this.isModified=false;
    });
  }
}
