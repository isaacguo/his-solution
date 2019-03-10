import {AfterViewInit, Component, ElementRef, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/timer';
import {GuardDelegation} from "../../guards/guard-delegation";
import {AuthInfo} from "../../services/common/authentication.service";

declare let $: any;

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, AfterViewInit {

  @Input()
  displayName: string;
  @Input()
  authInfo: AuthInfo;
  @Input()
  guardMap: Map<string, GuardDelegation>;

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
