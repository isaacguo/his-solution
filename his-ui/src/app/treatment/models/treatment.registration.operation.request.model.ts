export interface TreatmentRegistrationOperationRequestModel {
  doctorId?: number,
  operatorId?: number,
  petId?: number,
  bookDate?: Date,
  registrationStatus?: string,
  indexOfDay?: number,
  id?: number,
  priceUuid?:string

}
