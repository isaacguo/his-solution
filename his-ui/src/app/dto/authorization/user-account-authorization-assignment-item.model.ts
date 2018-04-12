import {AuthorizationAssignment} from "./authorization-assignment.model";

export class UserAccountAuthorizationAssignmentItem {
  public userAccount?: string;
  public authorizationAssignmentList?: AuthorizationAssignment[];

  constructor() {
  }

}
