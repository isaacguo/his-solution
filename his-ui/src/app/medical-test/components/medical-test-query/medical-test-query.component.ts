import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-medical-test-query',
  templateUrl: './medical-test-query.component.html',
  styleUrls: ['./medical-test-query.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestQueryComponent implements OnInit {

  @Input()
  reports:any[];

  constructor() { }

  ngOnInit() {
  }

}
