import {Injectable} from '@angular/core';
import {GuardDelegation} from "../guards/guard-delegation";
import {AuthorizationService} from "./common/authorization.service";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Injectable()
export class GuardFactoryService {

  private map = new Map<string, GuardDelegation>();
  private domainMap = new Map<string, GuardDelegation[]>();
  private subject = new BehaviorSubject<Map<string, GuardDelegation>>(this.map);
  private observableGuardsMap$ = this.subject.asObservable();

  public getObservableGuardsMap() {
    return this.observableGuardsMap$;
  }


  constructor(private authorizationService: AuthorizationService) {
  }

  addGuard(domain: string, topic: string, operation: string) {
    let dg = new GuardDelegation(domain, topic, operation, this.authorizationService);
    this.map.set(domain + '-' + topic + '-' + operation, dg);
    if (!this.domainMap.has(domain))
      this.domainMap.set(domain, []);
    this.domainMap.get(domain).push(dg);
    this.subject.next(this.map);
  }

  getGuard(key: string): CanActivate {
    if (this.map.has(key))
      return this.map.get(key);
    else if (this.domainMap.has(key)) {
      {
        let self = this;
        return <CanActivate>{
          canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
            return (self.domainMap.get(key).find(r => r.canActivate(route,state))) ? true : false;
          }
        }
      }
    }
    else {
      return <CanActivate>{
        canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
          return false;
        }
      }
    }
  }
}
