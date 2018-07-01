import {Injectable} from '@angular/core';
import {AbstractService} from "./abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";

export class CrudService extends AbstractService {

  constructor(public rootUrl: string, protected authHttp: AuthHttp) {
    super()
  }

  create(dto: any): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}`, dto).map(this.extractData);
  }

  readOne(id: number): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/${id}`).map(this.extractData);
  }

  readAll(): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/`).map(this.extractData);
  }

  update(id:number,dto: any): Observable<any> {
    return this.authHttp.put(`${this.rootUrl}/${id}`, dto).map(this.extractData);
  }

  deleteOne(id: number): Observable<any> {
    return this.authHttp.delete(`${this.rootUrl}/${id}`).map(this.extractData);
  }

}
