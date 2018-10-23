import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges
} from '@angular/core';

@Component({
  selector: 'app-employee-management-list-view',
  templateUrl: './employee-management-list-view.component.html',
  styleUrls: ['./employee-management-list-view.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementListViewComponent implements OnInit,OnChanges {

  @Input()
  pageData: any;

  @Output()
  employeeEdited = new EventEmitter<any>();
  @Output()
  pageChanged=new EventEmitter<number>();


  constructor() {
  }

  ngOnInit() {
  }

  onPageChanged(event) {
    this.pageChanged.emit(event-1);
  }

  onViewButtonClicked(uuid: string) {

  }
  onEditButtonClicked(uuid:string)
  {
    this.employeeEdited.emit({uuid:uuid});
  }

  ngOnChanges(changes: SimpleChanges): void {
  }
}
