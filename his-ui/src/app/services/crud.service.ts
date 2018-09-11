import {Injectable} from '@angular/core';
import {AbstractService} from "./abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

export class CrudService<T> extends AbstractService {

  private items = new BehaviorSubject<T[]>([]);

  private loadData() {
    this.authHttp.get(`${this.rootUrl}`).subscribe((items) => {
      this.items.next(this.extractArrayData(items));
    });
  }

  getItems() {
    return this.items.asObservable();
  }

  constructor(public rootUrl: string, protected authHttp: AuthHttp) {
    super()
  }

  createItem(data: T) {
    this.authHttp.post(`${this.rootUrl}`, data).subscribe(() => {
      this.loadData()
    });
  }


  //old
  create(dto: any): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}`, dto).map(this.extractData);
  }

  readOne(id: number): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/${id}`).map(this.extractData);
  }

  readAll(): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}`).map(this.extractData);
  }

  update(id: number, dto: any): Observable<any> {
    return this.authHttp.put(`${this.rootUrl}/${id}`, dto)

  }

  deleteOne(id: number): Observable<boolean> {
    return this.authHttp.delete(`${this.rootUrl}/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

}
