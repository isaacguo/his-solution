import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {ProcurementStatus} from "../../dto/procurement/procurement-status.model";
import {ProcurementApprovalStage} from "../../dto/procurement/procurement-approval-stage.model";
import {ProcurementApproval} from "../../dto/procurement/procurement-approval.model";

@Injectable()
export class ProcurementApprovalService extends AbstractService {

  private rootUrl: string = "/api/hisprocurement/procurement-approval";

  private findMyUnfinishedApprovalsUrl: string = `${this.rootUrl}/approvals`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  getRoot(): Observable<ProcurementApprovalStage> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findMyUnfinishedApprovals(): Observable<ProcurementApproval[]> {
    return this.authHttp.get(this.findMyUnfinishedApprovalsUrl).map(this.extractData);
  }

}
