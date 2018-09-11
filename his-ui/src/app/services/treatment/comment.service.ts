import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../components/common/service-constants";
import {AuthHttp} from "angular2-jwt";
import {TreatmentComment} from "../../dto/treatment/treatment-comment.model";

@Injectable()
export class CommentService extends CrudService<TreatmentComment> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/comments`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/comments`, authHttp);
  }



}
