import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {PopupModalBundle} from "../../models/popup-modal-bundle.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-popup-modal',
  templateUrl: './popup-modal.component.html',
  styleUrls: ['./popup-modal.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PopupModalComponent implements OnInit {

  @ViewChild("popupModal")
  popupModal: ModalComponent;

  _bundle: PopupModalBundle;

  @Input()
  set bundle(bundle: PopupModalBundle) {
    this._bundle = bundle;
    if (bundle.title)
      this.popupModal.open();
  }

  @Output()
  modalClosed = new EventEmitter<any>();


  constructor() {
  }

  ngOnInit() {
  }

  onPopupModalClosed() {
    this.modalClosed.emit(this._bundle.payload ? this._bundle.payload : {});
  }
}
