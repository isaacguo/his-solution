import {Department} from "./department.model";

export class TreatmentEmployeeModel {
  constructor(public department?: Department,
              public departmentId?:number,
              public id?: number,
              public empId?:number,
              public loginAccount?:string,
              public selfIntroduction?: string,
              public uuid?:string,
              public canBeRegistered?: boolean,
              public name?: string,) {

  }
}
