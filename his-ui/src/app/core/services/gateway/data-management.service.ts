import {Injectable} from '@angular/core';
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DataManagementService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.GATEWAY_URL}/data-management`;

  constructor(authHttp: AuthHttp) {
    super
    (`${ServiceConstants.GATEWAY_URL}/data-management`, authHttp);
  }

  backup(): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/backup`, {}).map(this.extractData);
  }

  getBackupFiles(folderName: string): Observable<string[]> {
    return this.authHttp.get(`${this.rootUrl}/get-backup-files/${folderName}`).map(this.extractData);
  }


  getBackupFolders(): Observable<string[]> {
    return this.authHttp.get(`${this.rootUrl}/get-backup-folders`).map(this.extractData);
  }

  restoreFolder(fileName: string): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/restore`, {fileName: fileName}).map(this.extractData);
  }
}
