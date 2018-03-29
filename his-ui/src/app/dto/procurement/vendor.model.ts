import {Contact} from "./contact.model";

export class Vendor {

  public id?: number;
  public name?: string;
  public address?: string;
  public postcode?: string;
  public description?: string;
  public officialWebsiteLink?: string;
  public email:string;
  public contacts?: Contact[];

  constructor() {
  }

}
