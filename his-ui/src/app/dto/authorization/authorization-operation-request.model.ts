import {AuthorizationAssignmentOperationRequest} from "./authorization-assignment-operation-request.model";

export class AuthorizationOperationRequest {
  public id:number;
  public uid: number;
  public username: string;
  public authorizationAssignmentList: AuthorizationAssignmentOperationRequest[];

  constructor(){}
}
