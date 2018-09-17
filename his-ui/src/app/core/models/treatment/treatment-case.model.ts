import {Department} from "./department.model";
import {Doctor} from "./doctor.model";
import {PetOwner} from "./pet-owner.model";
import {Pet} from "./pet.model";
import {TreatmentCaseComment} from "./treatment-comment.model";
import {TreatmentCaseStatusEnum} from "../../enums/treatment-case-status.enum";

export interface TreatmentCase {

  treatmentDate?: Date,
  createdDate?: Date,
  department?: Department,
  doctor?: Doctor,
  petOwner?: PetOwner,
  pet?: Pet,
  id?: number,
  uuid?: string,
  treatmentCaseStatus?: TreatmentCaseStatusEnum,
  createResult?: boolean,
  comments?: TreatmentCaseComment[]
}
