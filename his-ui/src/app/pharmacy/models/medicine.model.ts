export interface Medicine {
  readonly name: string;
  readonly id: number;
  readonly packageUnit: string; //包装规格单位  瓶，盒
  readonly packageCount: string; //包装规格数量
  readonly medicineSpecificationUnit: string; //药品规格单位
  readonly medicineSpecification: string; //药品规格 药品规格就是药品最小包装或最小单体的一个量度值
  readonly dosagePerDay: string;  //每日药品剂量
  readonly count:number;

}
