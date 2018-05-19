export class DepartmentOperationRequest {
  constructor(public exposeToPublic?: boolean ,
              public openToFrontDesk?:boolean,
              public depId?: number,
              public name?: string,
              public description?: string,
              public id?: number) {
  }

}
