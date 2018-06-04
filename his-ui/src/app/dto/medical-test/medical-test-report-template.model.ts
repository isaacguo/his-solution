import {MedicalTestReportTemplateItem} from "./medical-test-report-template-item.model";

export class MedicalTestReportTemplate {
  public reportTemplateItems: MedicalTestReportTemplateItem[];
  public id: number;
  public reportName: string;

  constructor() {
  }
}
