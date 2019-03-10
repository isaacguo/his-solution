import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-pet-info',
  templateUrl: './pet-info.component.html',
  styleUrls: ['./pet-info.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetInfoComponent implements OnInit {

  @Input()
  pet:any;

  constructor() {
    this.pet={};
  }

  ngOnInit() {
  }

}
