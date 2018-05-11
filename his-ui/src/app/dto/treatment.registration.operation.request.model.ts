export class TreatmentRegistrationOperationRequestModel {
  constructor(public  doctorId?: number,
              public  operatorId?: number,
              public  petId?: number,
              public  bookDate?: Date,
              public  indexOfDay?: number,
              public  id?: number) {

  }
}
