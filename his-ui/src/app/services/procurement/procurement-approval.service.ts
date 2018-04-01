import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {ProcurementStatus} from "../../dto/procurement/procurement-status.model";
import {ProcurementApprovalStage} from "../../dto/procurement/procurement-approval-stage.model";
import {ProcurementApproval} from "../../dto/procurement/procurement-approval.model";
import {Procurement} from "../../dto/procurement/procurement.model";
import {ProcurementApprovalOperationRequest} from "../../dto/procurement/procurement-approval-operation-request.model";

@Injectable()
export class ProcurementApprovalService extends AbstractService {

  private rootUrl: string = "/api/hisprocurement/procurement-approval";

  private findMyUnfinishedApprovalProcurementsUrl: string = `${this.rootUrl}/approvals`;

  private updateUrl: string =  `${this.rootUrl}/update`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  getRoot(): Observable<ProcurementApprovalStage> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findMyUnfinishedApprovals(): Observable<Procurement[]> {
    return this.authHttp.get(this.findMyUnfinishedApprovalProcurementsUrl).map(this.extractData);
  }

  updateApproval(request:ProcurementApprovalOperationRequest):Observable<boolean>{
    return this.authHttp.post(this.updateUrl,request).map(r=>{
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
