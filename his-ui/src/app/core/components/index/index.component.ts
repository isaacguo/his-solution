import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/observable/timer';

declare let $: any;

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, OnDestroy, AfterViewInit {

  userName: string;

  private authChangeSubscription: Subscription;
  private unfinishedTaskCountSubscriptiion: Subscription;
  count: number = 0;

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
    this.unfinishedTaskCountSubscriptiion.unsubscribe();
  }

  getCount(): string {
    if (this.count == 0)
      return "";
    else
      return this.count + "";
  }

  constructor(private elementRef: ElementRef,
  ) {


  }

  canShowApproval(): boolean {
    return true;
  }

  canShowEmployeeManagement(): boolean {
    return true;
  }

  canShowFrontdesk(): boolean {
    return true;
  }

  canShowMedicineManagement(): boolean {
    return true;
  }

  canShowInventoryManagement(): boolean {
    return true;
  }

  canShowInpatientManagement(): boolean {
    return true;
  }

  canShowMedicalTestManagement(): boolean {
    return true;
  }

  canShowFinanceManagement(): boolean {
    return true;
  }

  canShowMyConsultingRoom(): boolean {
    return true;
  }

  canShowProcurementManagement(): boolean {
    return true;
  }

  ngOnInit() {
    this.canShowApproval();
    this.canShowEmployeeManagement()
  }

  canShowTreatmentSettings() {
    return true;
  }
  isAdmin()
  {
    return true;
  }

  canShowPriceManagement() {
    return true;

  }

  canShowChargeManagement() {
    return true;
  }

  ngAfterViewInit(): void {
    Observable.timer(2000).subscribe(r => {
      let menuElement = this.elementRef.nativeElement.querySelector('#side-menu');
      $('#side-menu').metisMenu();
    })
  }

}
