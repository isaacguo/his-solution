import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Pet} from "../../../treatment/models/pet.model";
import {PetOwner} from "../../../treatment/models/pet-owner.model";
import {PetOperationRequest} from "../../../treatment/models/pet.operation.request";
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";

@Injectable()
export class PetService extends CrudService<Pet> {

  petInfoChange: Observable<PetInfo>;
  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/pets`;

  selectedPet: Pet = {};
  selectedPetOwner: PetOwner = {};
  private petInfoManager: BehaviorSubject<PetInfo> = new BehaviorSubject(new PetInfo(null, null, null));
  private petInfo: PetInfo;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/pets`, authHttp);
  }

  findOne(id:number):Observable<Pet>
  {
    let url = `${this.rootUrl}/${id}`;
    return this.authHttp.get(url).map(this.extractData);
  }

  findPetOwner(petOperationRequest: PetOperationRequest): Observable<PetOwner> {
    let url = `${this.rootUrl}/find-pet-owner`;
    return this.authHttp.post(url, petOperationRequest).map(this.extractData);
  }

  findByUuid(uuid: string): Observable<any> {
    let url = `${this.rootUrl}/find-by-uuid/${uuid}/`;
    return this.authHttp.get(url).map(this.extractData);
  }

  findByUuids(uuids: any[]): Observable<any[]> {

    let url = `${this.rootUrl}/find-by-uuids`;
    return this.authHttp.post(url, uuids).map(this.extractData);
  }

  public setPetInfo(newPetInfo: PetInfo): void {
    this.petInfo = newPetInfo;
    this.petInfoManager.next(this.petInfo);
  }

  clearPetInfo() {

    this.petInfo = {'pet': null, 'petOwner': null, 'registration': null};
    this.petInfoManager.next(this.petInfo);

  }


}

export class PetInfo {

  constructor(public pet?: any, public petOwner?: any, public registration?: any) {

  }

}
