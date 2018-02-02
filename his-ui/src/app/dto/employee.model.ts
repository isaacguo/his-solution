import {Department} from "./department.model";
import {ContactAddress} from "./employee.contact.model";
import {SexualEnum} from "../enums/sexual.enum";
import {EmploymentStatusEnum} from "../enums/employment.status.enum";

export class Employee {
  constructor(public givenName?: number,
              public surname?: string,
              public employeeNumber?: string,
              public idNumber?: string,
              public driverLicenseNumber?: string,
              public dateOfBirth?: Date,
              public gender?: SexualEnum,
              public nationality?: string,
              public ethnic?: string,
              public email?: string,
              public maritalStatus?: string,
              public joinedDate?: Date,
              public jobTitle?: string,
              public employmentStatus?: EmploymentStatusEnum,
              public directReportTo?: Employee,
              public teamMembers?: Employee[],
              public department?: Department,
              public emergencyContact?: string,
              public workPhoneNumber?:string,
              public contactAddress?:ContactAddress,
              public emergencyPhoneNumber?: string,
              public uuid?:string) {
  }
}
