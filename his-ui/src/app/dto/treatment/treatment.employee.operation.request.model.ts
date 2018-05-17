export class TreatmentEmployeeOperationRequestModel {
  constructor(public departmentId: number,
              public id: number,
              public selfIntroduction: string,
              public employeeTypeId: number,
              public name: string) {
  }

}
