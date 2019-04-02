export interface InpatientManagement {

  inDate: Date;
  outDate: Date;
  managementStatus: string;
  petUuid: string;
  requestDoctorUuid: string;
  reasonToInpatient: string;
  petStatus: string
}
