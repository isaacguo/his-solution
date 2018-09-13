import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Employee} from "../../../dto/employee/employee.model";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-employee-profile-picture',
  templateUrl: './employee-profile-picture.component.html',
  styleUrls: ['./employee-profile-picture.component.css']
})
export class EmployeeProfilePictureComponent implements OnChanges {

  @Input()
  employee: Employee;
  pictureSafeUrl: SafeResourceUrl;

  constructor(private sanitizer: DomSanitizer) {

  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.employee) {
      if (this.employee != null)
        this.pictureSafeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.employee.pictureUrl);
      else
        this.pictureSafeUrl = this.sanitizer.bypassSecurityTrustResourceUrl('/assets/user.svg');

    }
  }

}
