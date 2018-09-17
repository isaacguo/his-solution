import {Department} from "./department.model";

export interface TreatmentEmployeeModel {
  department?: Department,
  departmentId?: number,
  id?: number,
  empId?: number,
  loginAccount?: string,
  selfIntroduction?: string,
  uuid?: string,
  canBeRegistered?: boolean,
  name?: string
}
