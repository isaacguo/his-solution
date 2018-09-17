import {AuthorizationTopic} from "./authorization-topic.model";
import {TopicOperation} from "./topic-operation.model";

export class AuthorizationAssignment {

  public id?: number;
  topic?: AuthorizationTopic;
  allowedOperations?: TopicOperation[];

  constructor() {
  }

}

