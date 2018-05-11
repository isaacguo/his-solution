export class VendorProduct {

  public id?: number;
  public children?: VendorProduct[];
  public productEnglishName?: string;  //产品英文名
  public productChineseName?: string;  //产品中文名
  public orderNumber?: string;   //订货号
  public productSet?: boolean;
  public currency?: string;
  public packageSpecification?: string; //包装规格
  public packageUnit?: string; //销售单位
  public pricePerUnit?: number;

  constructor() {
  }
}
