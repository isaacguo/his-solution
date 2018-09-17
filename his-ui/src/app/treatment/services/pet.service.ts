import {Injectable} from '@angular/core';
import {AbstractService} from "../../core/services/abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Pet} from "../models/pet.model";
import {PetOwner} from "../models/pet-owner.model";
import {PetOperationRequest} from "../models/pet.operation.request";

@Injectable()
export class PetService extends AbstractService {

  petInfoChange: Observable<PetInfo>;
  rootUrl: string = "/api/histreatment/pets";
  selectedPet: Pet = {};
  selectedPetOwner: PetOwner = {};
  private petInfoManager: BehaviorSubject<PetInfo> = new BehaviorSubject(new PetInfo(null, null, null));
  private petInfo: PetInfo;

  constructor(private authHttp: AuthHttp) {
    super();
    this.petInfoChange = this.petInfoManager.asObservable();
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
