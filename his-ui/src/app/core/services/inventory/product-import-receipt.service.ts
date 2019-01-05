import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class ProductImportReceiptService extends CrudService<any>  {

  rootUrl: string = "/api/hismedicine/import-receipts";

  constructor(authHttp: AuthHttp) {
    super("/api/hismedicine/import-receipts", authHttp);
  }

}
