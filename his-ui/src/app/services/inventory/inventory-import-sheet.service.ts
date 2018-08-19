import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class InventoryImportSheetService extends CrudService  {

  rootUrl: string = "/api/hismedicine/import-sheets";

  constructor(authHttp: AuthHttp) {
    super("/api/hismedicine/import-sheets",authHttp);
  }

}
