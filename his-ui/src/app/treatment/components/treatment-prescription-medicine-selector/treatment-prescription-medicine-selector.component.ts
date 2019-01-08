import {ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {Observable} from "rxjs";
import {InventoryItemService} from "../../../core/services/inventory/inventory-item.service";

@Component({
  selector: 'app-treatment-prescription-medicine-selector',
  templateUrl: './treatment-prescription-medicine-selector.component.html',
  styleUrls: ['./treatment-prescription-medicine-selector.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentPrescriptionMedicineSelectorComponent implements OnInit {

  results: Observable<any[]>;
  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  @Output()
  medicineSelected = new EventEmitter<any>();


  constructor(private inventoryItemService: InventoryItemService) {

    this.results = this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {
        if (!name) {
          console.log('empty')
          return Observable.of([]);
        } else {
          return this.inventoryItemService.findByNameContains(name);
        }
      }).shareReplay(2);
  }


  stopPropagation($event) {
    event.stopPropagation()
  }

  ngOnInit() {
  }

  addMedicine(medicine: any) {
    this.medicineSelected.emit(medicine);
  }
}
