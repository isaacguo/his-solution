import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {TreatmentCase} from "../../../dto/treatment/treatment-case.model";

@Component({
  selector: 'app-treatment-comments-container',
  templateUrl: './treatment-comments-container.component.html',
  styleUrls: ['./treatment-comments-container.component.css']
})
export class TreatmentCommentsContainerComponent implements OnInit {


  selectedTreatmentCase:Observable<TreatmentCase>;
  comments:Observable<any[]>;

  constructor() { }

  ngOnInit() {
  }

}
