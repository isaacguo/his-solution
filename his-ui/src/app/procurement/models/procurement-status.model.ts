export class ProcurementStatus {

  public status?: string;
  public next?: ProcurementStatus[];
  public parent?: ProcurementStatus;
  public id?: number;

  constructor() {
  }


}
