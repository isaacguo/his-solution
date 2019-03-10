import {AuthorizationAssignment} from "./authorization-assignment.model";

export interface UserAccountAuthorizationAssignmentItem {
  userAccount?: string;
  authorizationAssignmentList?: AuthorizationAssignment[];

}
