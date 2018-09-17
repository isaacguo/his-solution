import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-request-good',
  templateUrl: './request-good.component.html',
  styleUrls: ['./request-good.component.css']
})
export class RequestGoodComponent implements OnInit {


  @Input('good')
  public good: FormGroup;


  constructor() { }

  ngOnInit() {
  }

}
