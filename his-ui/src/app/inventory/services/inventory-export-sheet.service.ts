import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../../core/services/crud.service";

@Injectable()
export class InventoryExportSheetService extends CrudService<any>  {

  rootUrl: string = "/api/hismedicine/export-sheets";

  constructor(authHttp: AuthHttp) {
    super("/api/hismedicine/export-sheets",authHttp);
  }

}
