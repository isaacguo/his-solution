import {Injectable} from '@angular/core';
import {GuardDelegation} from "../guards/guard-delegation";
import {AuthorizationService} from "./common/authorization.service";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class GuardFactoryService {

  private map = new Map<string, GuardDelegation>();
  private subject = new BehaviorSubject<Map<string, GuardDelegation>>(this.map);
  private observableGuardsMap$ = this.subject.asObservable();

  public getObservableGuardsMap() {
    return this.observableGuardsMap$;
  }


  constructor(private authorizationService: AuthorizationService) {
  }

  addGuard(domain: string, topic: string, operation: string) {
    this.map.set(domain + '-' + topic + '-' + operation, new GuardDelegation(domain, topic, operation, this.authorizationService));
    this.subject.next(this.map);
  }

  getGuard(key: string): GuardDelegation {
    if (this.map.has(key))
      return this.map.get(key);
    else
      return null;
  }
}
