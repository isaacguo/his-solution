import {MedicalTestReportItem} from "./medical-test-report-item.model";

export class MedicalTestReport {
  public reportItems: MedicalTestReportItem[];
  public id: number;
  public reportName: string;

  constructor() {
  }
}
