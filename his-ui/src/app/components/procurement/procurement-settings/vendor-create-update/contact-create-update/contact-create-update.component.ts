import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-contact-create-update',
  templateUrl: './contact-create-update.component.html',
  styleUrls: ['./contact-create-update.component.css']
})
export class ContactCreateUpdateComponent implements OnInit {

  @Input('contact')
  public contact: FormGroup;

  constructor() { }

  ngOnInit() {
  }

}
