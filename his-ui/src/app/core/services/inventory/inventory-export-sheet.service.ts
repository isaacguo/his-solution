import { Injectable } from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class InventoryExportSheetService extends CrudService<any>  {

  rootUrl: string = `${ServiceConstants.MEDICINE_URL}/export-sheets`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.MEDICINE_URL}/export-sheets`,authHttp);
  }

}
