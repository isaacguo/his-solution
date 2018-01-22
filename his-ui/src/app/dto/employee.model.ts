import {Department} from "./department.model";

export class Employee {
  constructor(public givenName?: number,
              public surname?: string,
              public employeeNumber?: string,
              public idNumber?: string,
              public driverLicenseNumber?: string,
              public dateOfBirth?: Date,
              public gender?: string,
              public nationality?: string,
              public ethnic?: string,
              public email?: string,
              public maritalStatus?: string,
              public joinedDate?: Date,
              public jobTitle?: string,
              public employmentStatus?: string,
              public directReportTo?: Employee,
              public teamMembers?: Employee[],
              public department?: Department,
              public emergencyContact?: string,
              public emergencyPhoneNumber?: string) {
  }
}
