export class ProcurementApprovalStage {
  public stage: string;
  public nextStage: ProcurementApprovalStage;
  public previousStage: ProcurementApprovalStage;
  public id: number;

  constructor() {
  }
}
