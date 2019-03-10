import {Vendor} from "./vendor.model";
import {VendorPermitDepartment} from "../../core/models/employee/vendor-permit-department.model";

export class VendorCategory {
  public id: number;
  public name: string;

  //List<VendorCategoryEntity> children = new LinkedList<>();
  public vendors: Vendor[];
  public departments: VendorPermitDepartment[];

  constructor() {
  }

}
