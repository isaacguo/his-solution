import {Injectable} from '@angular/core';
import {CrudService} from "../../core/services/crud.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {TreatmentCaseComment} from "../models/treatment-comment.model";
import {ServiceConstants} from "../../shared/service-constants";

@Injectable()
export class CommentService extends CrudService<TreatmentCaseComment> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/comments`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/comments`, authHttp);
  }


  createComment(comment: TreatmentCaseComment): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}`, comment);
  }

}
