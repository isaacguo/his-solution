import {AbstractService} from "./abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {PageableParams} from "../models/pageable-params.model";

export class CrudService<T> extends AbstractService {

  protected items = new BehaviorSubject<T[]>([]);
  protected pageData = new BehaviorSubject<any>(null);

  constructor(public rootUrl: string, protected authHttp: AuthHttp) {
    super()
  }


  public loadPageData(params?: PageableParams) {
    this.authHttp.get(`${this.rootUrl}`, params ? {params: params} : {
      params: {
        page: 0,
        size: 15
      }
    }).map(this.extractData).subscribe((page) => {
      this.pageData.next(page)
    });
  }

  public loadData(params?: string): Observable<T[]> {
    return this.authHttp.get(params ? `${this.rootUrl}/${params}` : `${this.rootUrl}`)
      .map(this.extractArrayData).do((items) => {
      this.items.next(items);
    }) ;
  }

  getPageDataAsObservable(): Observable<any> {
    return this.pageData.asObservable();
  }

  getObservableItems(): Observable<T[]> {
    return this.items.asObservable();
  }

  createItem(data: T) {
    this.authHttp.post(`${this.rootUrl}`, data).subscribe(() => {
      this.loadData()
    });
  }

  readItems() {
    this.loadData();
  }


  //old
  create(dto: any): Observable<T> {
    return this.authHttp.post(`${this.rootUrl}`, dto).map(this.extractData);
  }

  readOne(id: number): Observable<T> {
    return this.authHttp.get(`${this.rootUrl}/${id}`).map(this.extractData);
  }
  readOneByUuid(uuid: number): Observable<T> {
    return this.authHttp.get(`${this.rootUrl}/by-uuid/${uuid}`).map(this.extractData);
  }

  readAll(): Observable<T[]> {
    return this.authHttp.get(`${this.rootUrl}`).map(this.extractData);
  }

  update(id: number, dto: any): Observable<T> {
    return this.authHttp.put(`${this.rootUrl}/${id}`, dto).map(this.extractData);
  }

  deleteOne(id: number): Observable<boolean> {
    return this.authHttp.delete(`${this.rootUrl}/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

}
