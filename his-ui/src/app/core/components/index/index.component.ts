import {AfterViewInit, Component, ElementRef, Input, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/timer';

declare let $: any;

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, AfterViewInit {

  @Input()
  userName:string;


  constructor(private elementRef: ElementRef) {
  }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    Observable.timer(2000).subscribe(r => {
      let menuElement = this.elementRef.nativeElement.querySelector('#side-menu');
      $('#side-menu').metisMenu();
    })
  }


}
