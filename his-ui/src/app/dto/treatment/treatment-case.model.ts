import {Department} from "./department.model";
import {Doctor} from "./doctor.model";
import {PetOwner} from "./pet-owner.model";
import {Pet} from "./pet.model";
import {TreatmentCaseStatusEnum} from "../../enums/treatment-case-status.enum";

export class TreatmentCase {

  constructor(public treatmentDate?: Date,
              public createdDate?: Date,
              public department?: Department,
              public doctor?: Doctor,
              public petOwner?: PetOwner,
              public pet?: Pet,
              public id?: number,
              public uuid?: string,
              public treatmentCaseStatus?: TreatmentCaseStatusEnum,
              public createResult?: boolean) {
  }
}
