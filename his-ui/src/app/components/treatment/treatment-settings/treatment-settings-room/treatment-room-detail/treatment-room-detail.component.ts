import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-treatment-room-detail',
  templateUrl: './treatment-room-detail.component.html',
  styleUrls: ['./treatment-room-detail.component.css']
})
export class TreatmentRoomDetailComponent implements OnInit {

  @Input()
  room:number;

  constructor() { }

  ngOnInit() {
  }

}
