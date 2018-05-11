import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {PetOwner} from "../../dto/pet-owner.model";
import {Observable} from "rxjs/Rx";
import {PetOperationRequest} from "../../dto/pet.operation.request";
import {FormGroup} from "@angular/forms";
import {Vendor} from "../../dto/procurement/vendor.model";

@Injectable()
export class VendorService extends AbstractService {

  rootUrl: string = "/api/hisprocurement/vendors";
  private createVendorUrl: string = `${this.rootUrl}/create-vendor`;
  private updateVendorUrl: string = `${this.rootUrl}/update-vendor`
  private deleteVendorUrl: string = `${this.rootUrl}/delete-vendor`;
  private moveVendorUrl: string = `${this.rootUrl}/move-vendor`;
  private findByNameContainsUrl: string = `${this.rootUrl}/find-by-name-contains`;

  private permittedVendorUrl: string = `${this.rootUrl}/permitted`;


  constructor(private authHttp: AuthHttp) {
    super();
  }

  createVendor(request: FormGroup): Observable<Vendor> {
    return this.authHttp.post(this.createVendorUrl, request).map(this.extractData);
  }
  getPermittedVendors():Observable<Vendor[]>
  {
    return this.authHttp.get(this.permittedVendorUrl).map(this.extractData);
  }

  updateVendor(request: FormGroup) {
    return this.authHttp.post(this.updateVendorUrl, request).map(this.extractData);
  }

  findAll(): Observable<Vendor[]> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findById(updateId: number) {
    return this.authHttp.get(`${this.rootUrl}/${updateId}`).map(this.extractData);
  }

  deleteVendor(vendor: Vendor): Observable<boolean> {
    return this.authHttp.post(this.deleteVendorUrl, vendor).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  findByNameContains(name: string):Observable<Vendor[]> {
    return this.authHttp.get(`${this.findByNameContainsUrl}/${name}`).map(this.extractData);
  }

  moveToCategory(selectedCategoryId: number, id: number | undefined) {
    return this.authHttp.put(`${this.moveVendorUrl}`, {'categoryId':selectedCategoryId, 'id':id}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
