import {Injectable} from '@angular/core';
import {AbstractService} from "../../core/services/abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {ProcurementApprovalOperationRequest} from "../models/procurement-approval-operation-request.model";
import {Procurement} from "../models/procurement.model";
import {ProcurementApprovalStage} from "../models/procurement-approval-stage.model";

@Injectable()
export class ProcurementApprovalService extends AbstractService {

  private unfinishedTaskCount: BehaviorSubject<number> = new BehaviorSubject(0);
  unfinishedTasksChange: Observable<number>;

  private rootUrl: string = "/api/hisprocurement/procurement-approval";

  private findMyUnfinishedApprovalProcurementsUrl: string = `${this.rootUrl}/approvals`;
  private findMyUnfinishedApprovalProcurementsCountUrl: string = `${this.rootUrl}/count`;

  private updateUrl: string = `${this.rootUrl}/update`;

  constructor(private authHttp: AuthHttp) {
    super();
    this.unfinishedTasksChange = this.unfinishedTaskCount.asObservable();
  }

  getRoot(): Observable<ProcurementApprovalStage> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findMyUnfinishedApprovals(): Observable<Procurement[]> {
    return this.authHttp.get(this.findMyUnfinishedApprovalProcurementsUrl).map(this.extractData);
  }

  findMyUnfinishedApprovalCount(): Observable<string> {
    return this.authHttp.get(this.findMyUnfinishedApprovalProcurementsCountUrl).map(this.extractTextData);
  }

  updateUnfinishedApprovalCount() {
    this.findMyUnfinishedApprovalCount().subscribe(c => {
      this.emitUnfinishedTaskCount(Number(c));
    })
  }


  updateApproval(request: ProcurementApprovalOperationRequest): Observable<boolean> {
    return this.authHttp.post(this.updateUrl, request).map(r => {

      this.findMyUnfinishedApprovalCount().subscribe(c => {
        this.emitUnfinishedTaskCount(Number(c));
      })

      return this.extractTextData(r) === "true" ? true : false;

    });
  }

  emitUnfinishedTaskCount(count: number): void {
    this.unfinishedTaskCount.next(count);
  }
}
