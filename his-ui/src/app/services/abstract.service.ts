import {Observable} from "rxjs/Rx";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';

export class AbstractService {


  protected extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  protected handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
