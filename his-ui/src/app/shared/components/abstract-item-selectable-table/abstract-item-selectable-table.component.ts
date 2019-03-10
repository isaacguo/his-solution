import {EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';


export abstract class AbstractItemSelectableTableComponent<T> implements OnInit,OnChanges  {

  @Input()
  list: T[];
  @Output()
  listChanged=new EventEmitter();
  @Output()
  itemSelected = new EventEmitter<T>();

  selectedItem: T;

  ngOnInit() {
  }

  onRowClicked(item: T) {
    this.itemSelected.emit(item);
    this.selectedItem = item;
  }

  isRowSelected(item: T) {
    return item === this.selectedItem
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.listChanged.emit();
  }

}
