import {Medicine} from "./medicine.model";

export interface MedicineInfo {

  readonly receiptStatus?:string;
  readonly receiptId?:number;
  readonly petOwnerName?:string;
  readonly petName?:string;


  readonly medicines?:Medicine[];

}
