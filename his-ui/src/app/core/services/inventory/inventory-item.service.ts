import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../crud.service";

@Injectable()
export class InventoryItemService  extends CrudService<any>{


  rootUrl: string = "/api/hismedicine/inventory-items";

  constructor(
    authHttp: AuthHttp) {
    super("/api/hismedicine/inventory-items",authHttp);
  }

  deleteById(updateId: number):Observable<boolean> {
    return this.authHttp.delete(`${this.rootUrl}/${updateId}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  findByNameContains(keyword:string):Observable<any[]>
  {
    return this.authHttp.get(`${this.rootUrl}/find-by-name-contains/${keyword}`).map(this.extractData);
  }
}
