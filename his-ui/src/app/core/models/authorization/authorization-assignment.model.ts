import {AuthorizationTopic} from "./authorization-topic.model";
import {TopicOperation} from "./topic-operation.model";

export interface AuthorizationAssignment {
  id?: number;
  topic?: AuthorizationTopic;
  allowedOperations?: TopicOperation[];

}

