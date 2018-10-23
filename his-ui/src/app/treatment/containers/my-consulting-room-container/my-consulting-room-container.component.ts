import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Registration} from "../../models/registration.model";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";

@Component({
  selector: 'app-my-consulting-room-container',
  templateUrl: './my-consulting-room-container.component.html',
  styleUrls: ['./my-consulting-room-container.component.css']
})
export class MyConsultingRoomContainerComponent implements OnInit {

  registration$: Observable<TreatmentRegistrationModel[]>;

  constructor(private registrationService: RegistrationService,
              private router: Router,
              private route: ActivatedRoute) {
    this.registration$ = this.registrationService.findMyRegistrationToday()
  }

  ngOnInit() {
  }

  onRegistrationSelected(event: TreatmentRegistrationModel) {
    this.router.navigate(['registrations', event.rid], {relativeTo: this.route});
  }

}
