import {AuthorizationAssignmentOperationRequest} from "./authorization-assignment-operation-request.model";

export class AuthorizationOperationRequest {
  id: number;
  uid: number;
  username: string;
  userAccount: string;
  authorizationAssignmentList: AuthorizationAssignmentOperationRequest[];

}
