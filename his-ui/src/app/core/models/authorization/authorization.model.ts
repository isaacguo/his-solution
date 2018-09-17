import {AuthorizationAssignment} from "./authorization-assignment.model";

export class Authorization {
  id?: number;
  uid?: string;
  username?: string;
  userAccount?:string;
  authorizationAssignmentList?: AuthorizationAssignment[];

  constructor() {
  }

}
