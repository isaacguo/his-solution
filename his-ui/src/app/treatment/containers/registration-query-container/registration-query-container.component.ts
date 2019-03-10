import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {PageableParams} from "../../../core/models/pageable-params.model";
import {RegistrationStatusEnum} from "../../../core/enums/registration-status.enum";

@Component({
  selector: 'app-registration-query-container',
  templateUrl: './registration-query-container.component.html',
  styleUrls: ['./registration-query-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class RegistrationQueryContainerComponent implements OnInit {

  pageInfoSubject = new BehaviorSubject<PageableParams>({size: 15, status: "WAITING", page: 0});
  pageInfo$ = this.pageInfoSubject.asObservable();
  pageData$: Observable<any>;
  selectedStatus$:Observable<string>;


  constructor(private registrationService: RegistrationService) {
    this.pageData$ = this.pageInfo$.mergeMap(page => this.registrationService.findAllRegistrationsByStatusOnPage(page.page, page.status, page.size))
    this.selectedStatus$=this.pageInfo$.map(data=>RegistrationStatusEnum[data.status]);
  }

  ngOnInit() {
  }

  onPageChanged(event) {
    this.pageInfoSubject.next(event);

  }

  onStatusChanged(event: PageableParams) {
    this.pageInfoSubject.next({...event, page: 0});
  }
}
