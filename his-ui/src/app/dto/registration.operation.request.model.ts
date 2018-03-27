export class RegistrationOperationRequestModel {
  constructor(indexOfDay: number,
              public id: number,
              public bookDate: Date,
              public doctorId: number,
              public operatorId: number,
              public petId: number) {
  }
}
