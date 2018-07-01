import {Component, OnInit} from '@angular/core';
import {RegistrationService} from "../../../../services/treatment/registration.service";
import {RegistrationStatusEnum} from "../../../../enums/registration-status.enum";

@Component({
  selector: 'app-registration-query',
  templateUrl: './registration-query.component.html',
  styleUrls: ['./registration-query.component.css']
})
export class RegistrationQueryComponent implements OnInit {

  page: any={};

  constructor(private registrationService: RegistrationService) {
  }

  registrations: any[] = [];

  ngOnInit() {
    this.loadData();
  }

  loadData(page: number = 0) {

    this.registrationService.findAllRegistrationsByStatusOnPage(page).subscribe(r => {
      this.registrations = r.content;
      this.page = r;
    })
  }

  onPageChanged(event: number) {
    this.loadData(event-1);
  }
  getRegistrationStatusString(reg: RegistrationStatusEnum): string {
    return RegistrationStatusEnum[reg];
  }
}
