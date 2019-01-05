export interface MedicalTestReport {

  reportName:string;
  reportInfoList: any[];
  reportItems: any[];
  createdDateTime: Date;
  paidDateTime: Date;
  finishedDateTime: Date;
  reportStatus: string;
  id: number;
  uuid: string;

}
