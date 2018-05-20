export class Department {
  constructor(public exposeToPublic?: boolean ,
              public openToFrontDesk?:boolean,
              public depId?: number,
              public uuid?:string,
              public name?: string,
              public description?: string,
              public id?: number) {
  }

}
