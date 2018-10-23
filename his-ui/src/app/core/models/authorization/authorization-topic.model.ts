import {TopicOperation} from "./topic-operation.model";


export interface AuthorizationTopic {

  id?: number;
  name?: AuthorizationTopic;
  availableTopicOperationList?: TopicOperation[];
}
