import {Department} from "./department.model";

export class TreatmentEmployeeModel {
  constructor(public department?: Department,
              public id?: number,
              public selfIntroduction?: string,
              public name?: string,) {

  }
}
