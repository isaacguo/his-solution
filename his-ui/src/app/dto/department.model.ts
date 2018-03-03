import {TreatmentCase} from "./treatment-case.model";

export class Department {
  constructor(public uuid?: string,
              public name?: string,
              public description?: string,
              public id?:number
              ) {
  }

}
