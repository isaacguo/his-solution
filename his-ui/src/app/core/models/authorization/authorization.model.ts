import {AuthorizationAssignment} from "./authorization-assignment.model";

export interface Authorization {
  id?: number;
  uid?: string;
  username?: string;
  userAccount?: string;
  authorizationAssignmentList?: AuthorizationAssignment[];
}
