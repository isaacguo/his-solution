import {ChangeDetectionStrategy, Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-profile-picture',
  templateUrl: './profile-picture.component.html',
  styleUrls: ['./profile-picture.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ProfilePictureComponent implements OnChanges {

  @Input()
  pictureUrl: string;

  pictureSafeUrl: SafeResourceUrl;

  constructor(private sanitizer: DomSanitizer) {

    this.pictureSafeUrl = this.sanitizer.bypassSecurityTrustResourceUrl('/assets/user.svg');

  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes.employee) {
      if (this.pictureUrl)
        this.pictureSafeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.pictureUrl);
      else
        this.pictureSafeUrl = this.sanitizer.bypassSecurityTrustResourceUrl('/assets/user.svg');
    }
  }

}
