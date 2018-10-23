import {ContactAddress} from "./employee.contact.model";
import {EmployeeDepartment} from "./employee-department.model";
import {SexualEnum} from "../../enums/sexual.enum";
import {EmploymentStatusEnum} from "../../enums/employment.status.enum";

export class Employee {
  constructor(public id?: number,
              public loginAccount?: string,
              public givenName?: number,
              public surname?: string,
              public fullName?: string,
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
              public department?: EmployeeDepartment,
              public emergencyContact?: string,
              public workPhoneNumber?: string,
              public contactAddress?: ContactAddress,
              public emergencyPhoneNumber?: string,
              public uuid?: string,
              public pictureUrl?: string) {
  }
}
