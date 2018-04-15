import {VendorPermitDepartment} from "../employee/vendor-permit-department.model";

export class MyTreeNode {
  public name?: string;
  public id?: any;
  public children?: MyTreeNode[];
  public hasChildren?: boolean;
  public isExpanded?: boolean;
  public categoryId?: number;
  public isLevelOne?: boolean;
  public departments?: VendorPermitDepartment[];

  constructor() {
  }

  findById(id: number): MyTreeNode {
    if (this.id === id) return this;
    else if (this.children != null && this.children.length > 0) {
      for (let child of this.children) {
        let found = child.findById(id);
        if (found != null) return found;
      }
    }
    else return null;
  }
}
