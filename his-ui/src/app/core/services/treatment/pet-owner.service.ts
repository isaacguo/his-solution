import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {Headers, RequestOptions, Response} from '@angular/http';
import {OperationEnum} from "../../enums/operation.enum";
import {PetOwner} from "../../../treatment/models/pet-owner.model";
import {Pet} from "../../../treatment/models/pet.model";
import {TreatmentCase} from "../../../treatment/models/treatment-case.model";
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../../shared/service-constants";


@Injectable()
export class PetOwnerService extends CrudService<PetOwner> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/owners`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/owners`, authHttp);
  }

  findPetOwnerByMemberNumber(memberNumber: string): Observable<PetOwner> {
    let url = `${this.rootUrl}/find-by-member-number/${memberNumber}`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  findPetOwnerByName(name: string): Observable<PetOwner[]> {
    let url = `${this.rootUrl}/find-by-name`;
    return this.authHttp.post(url, {name: name})
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
    else if (mode == OperationEnum.UPDATE) {
      let url = `${this.rootUrl}/update-pet`;
      return this.authHttp.put(url, pet)
        .map(this.extractData);
    }
  }

}
