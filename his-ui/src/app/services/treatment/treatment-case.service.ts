import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {CrudService} from "../crud.service";

@Injectable()
export class TreatmentCaseService extends CrudService {


  rootUrl: string = "/api/histreatment/treatment-cases";

  constructor(authHttp: AuthHttp) {
    super("/api/histreatment/treatment-cases",authHttp);
  }

  findAllByPetId(pid: number): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/find-all-by-pet/${pid}`).map(this.extractData);
  }

}
