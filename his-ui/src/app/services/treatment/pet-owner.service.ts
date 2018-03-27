import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {PetOwner} from "../../dto/pet-owner.model";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Pet} from "../../dto/pet.model";
import {OperationEnum} from "../../enums/operation.enum";


@Injectable()
export class PetOwnerService {


  rootUrl: string = "/api/histreatment/owners";

  constructor(private authHttp: AuthHttp) {
  }

  findPetOwnerByMemberNumber(memberNumber: string): Observable<PetOwner> {
    let url = `${this.rootUrl}/find-by-member-number/${memberNumber}`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  findPetOwnerByName(name: string): Observable<PetOwner[]> {
    let url = `${this.rootUrl}/find-by-name`;
    return this.authHttp.post(url, JSON.stringify({name: name}))
      .map(this.extractData);
  }

  deletePet(pet: Pet): Observable<PetOwner> {

    let headers = new Headers({'Content-Type': 'application/json'});

    let url = `${this.rootUrl}/delete-pet`;
    return this.authHttp.delete(url, new RequestOptions({
      headers: headers,
      body: pet
    }))
      .map(this.extractData);

  }

  operatePetOwner(petOwner: PetOwner, mode: OperationEnum): Observable<PetOwner> {
    if (mode == OperationEnum.CREATE) {
      let url = `${this.rootUrl}/create-pet-owner`;
      return this.authHttp.post(url, petOwner)
        .map(this.extractData);
    }
    else if (mode == OperationEnum.UPDATE) {
      let url = `${this.rootUrl}/update-pet-owner`;
      return this.authHttp.put(url, petOwner)
        .map(this.extractData);
    }
  }


  operatePet(pet: Pet, mode: OperationEnum): Observable<PetOwner> {
    if (mode == OperationEnum.CREATE) {
      let url = `${this.rootUrl}/add-pet`;
      return this.authHttp.post(url, pet)
        .map(this.extractData);
    }
    else if(mode==OperationEnum.UPDATE)
    {
      let url = `${this.rootUrl}/update-pet`;
      return this.authHttp.put(url, pet)
        .map(this.extractData);
    }
  }


  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: Response | any) {
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
