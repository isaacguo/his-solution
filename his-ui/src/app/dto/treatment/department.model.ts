export class Department {
  constructor(public exposeToPublic: boolean = false,
              public uuid: string,
              public name: string,
              public description?: string,
              public id?: number) {
  }

}
