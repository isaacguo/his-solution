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
import {MyTreeNode} from "../../../../dto/procurement/MyTreeNode";

@Component({
  selector: 'app-vendor-management',
  templateUrl: './vendor-management.component.html',
  styleUrls: ['./vendor-management.component.css']
})
export class VendorManagementComponent implements OnInit, OnChanges {
  @Input()
  departmentList: DepartmentListItem[];
  @Input()
  categoryId: number;

  isModified: boolean = false;
  @ViewChild("deleteResultModal") deleteResultModal: ModalComponent;
  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;
  @ViewChild("moveVendorModal") moveVendorModal: ModalComponent;
  deleteResultText: string;

  searchInput: FormControl = new FormControl('');
  vendors: Vendor[];
  vendorCategory: VendorCategory;
  vendorToBeDeleted: Vendor;
  nodes: MyTreeNode[] = [];
  selectedCategoryId: number;
  selectedCategory: MyTreeNode;

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

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  ngOnInit() {
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
    this.router.navigate(['procurement-settings', 'vendors', OperationEnum.CREATE, this.categoryId]);
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
    this.isModified = true;
    let department = this.vendorCategory.departments.find(r => r.departmentId === dep.id);
    if (department != null)
      department.permitted = event;
  }

  onUpdatePermissionButtonClicked() {

    this.vendorCategoryService.updateDepartmentPermission(this.vendorCategory.id, this.vendorCategory.departments).subscribe(r => {

      this.isModified = false;
    });
  }

  selectedVendorId: number;

  onMoveVendorButtonClicked(vendor: Vendor) {
    this.selectedVendorId = vendor.id;
    this.loadVendorCategoryList();
    this.moveVendorModal.open();
  }

  onMoveVendorModalClosed() {
    this.vendorService.moveToCategory(this.selectedCategoryId, this.selectedVendorId).subscribe(r => {
      this.loadData();
    })
  }

  onItemClicked(category: MyTreeNode) {
    this.selectedCategory = category;
    this.selectedCategoryId = category.categoryId;
  }

  isRowSelected(category) {

    if (this.selectedCategory === category)
      return true;
    else
      return false;
  }

  private loadVendorCategoryList() {
    this.vendorCategoryService.findAllForList().subscribe(r => {
      this.nodes = r;
    });
  }
}
