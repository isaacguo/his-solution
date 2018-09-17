import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../components/common/service-constants";
import {AuthHttp} from "angular2-jwt";
import {TreatmentCaseComment} from "../../dto/treatment/treatment-comment.model";
import {Observable} from "rxjs/Observable";

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
