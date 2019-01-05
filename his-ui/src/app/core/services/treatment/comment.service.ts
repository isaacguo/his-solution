import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreatmentCaseComment} from "../../../treatment/models/treatment-comment.model";
import {ServiceConstants} from "../../../shared/service-constants";
import {Observable} from "rxjs/Observable";

@Injectable()
export class CommentService extends CrudService<TreatmentCaseComment> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/comments`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/comments`, authHttp);
  }

  createComment(comment: TreatmentCaseComment) {
    this.create(comment).subscribe(r=>this.findByTreatmentCaseUuid(comment.treatmentCaseUuid));
  }

  findByTreatmentCaseUuid(uuid:string):Observable<TreatmentCaseComment[]> {
    return this.authHttp.get(`${this.rootUrl}/find-by-treatment-case-uuid/${uuid}`).map(this.extractArrayData);
  }
}