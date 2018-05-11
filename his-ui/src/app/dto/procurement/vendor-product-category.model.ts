import {VendorProduct} from "./vendor-product.model";

export class VendorProductCategory {

  public id?: number;
  public children?: VendorProductCategory[];
  public products?: VendorProduct[];
  public name?: string;

  constructor() {
  }
}
