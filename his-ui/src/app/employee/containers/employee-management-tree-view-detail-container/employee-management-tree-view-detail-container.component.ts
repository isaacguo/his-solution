import {AfterViewInit, ChangeDetectionStrategy, Component, OnDestroy, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../../core/services/employee/employee.service";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";
import {Observable} from "rxjs/Observable";
import {combineLatest} from "rxjs/observable/combineLatest";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Subscription} from "rxjs/Subscription";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Component({
  selector: 'app-employee-management-tree-view-detail-container',
  templateUrl: './employee-management-tree-view-detail-container.component.html',
  styleUrls: ['./employee-management-tree-view-detail-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementTreeViewDetailContainerComponent {

  @ViewChild("setAsManagerResultModal")
  setAsManagerResultModal: ModalComponent;

  operationDoneSubject = new BehaviorSubject<boolean>(false);
  operationDone$ = this.operationDoneSubject.asObservable();


  managerSubject = new BehaviorSubject<EmployeeListItem>({} as EmployeeListItem);
  preManager$ = this.managerSubject.asObservable();

  manager$: Observable<EmployeeListItem>;
  employeeList$: Observable<EmployeeListItem[]>;
  employeeListWithoutManager$: Observable<EmployeeListItem[]>;

  rootNode: Observable<MyTreeNode[]>;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private employeeService: EmployeeService,
              private treeNodeService: TreeNodeService,
              private employeeDepartmentService: EmployeeDepartmentService) {

    this.employeeList$ = combineLatest(route.params, this.operationDone$).mergeMap(([params, managerSet]) => {
      return this.employeeService.getEmployeeListByDepartmentId(params['departmentId']);
    }).shareReplay(3);
    this.preManager$ = combineLatest(route.params, this.operationDone$).mergeMap(([params, managerSet]) => {
      return this.employeeDepartmentService.findManager(params['departmentId']);
    }).shareReplay(2);


    this.manager$ = combineLatest(
      this.preManager$,
      this.employeeList$)
      .map(([manager, list]) => {
        if (manager) {
          let index = list.findIndex(m => {
            return m.uuid === manager.uuid;
          });
          if (index > -1) {
            //return list.splice(index, 1)[0];
            return list[index];
          }
        }
        else {
          return {} as EmployeeListItem;
        }
      });


    this.employeeListWithoutManager$ = combineLatest(this.employeeList$, this.manager$).map(([list, manager]) => {
      if (manager) {
        return list.filter(each => each.uuid != manager.uuid);
      }
      else return ([] as EmployeeListItem[]);
    });


    this.rootNode = this.employeeDepartmentService.getObservableRootDepartment().map(res => this.treeNodeService.treeConverter(res, true)).map(node => {
      let arr: MyTreeNode[] = [];
      arr.push(node);
      return arr;
    });
  }

  ngOnInit() {
  }

  onCreateNewEmployee() {
    this.route.params.subscribe(params => {
      this.router.navigate([OperationEnum.CREATE], {relativeTo: this.route});
    });
  }

  onEmployeeDepartmentAdjusted(event: any) {
    this.employeeService.moveEmployeeToDepartment(event).take(1)
      .subscribe(([]) => this.operationDoneSubject.next(true));
  }

  onEmployeeEdited(event: EmployeeListItem) {
    this.router.navigate([event.uuid, OperationEnum.UPDATE], {relativeTo: this.route});
  }

  onEmployeeManagerSet(event: EmployeeListItem) {

    this.employeeService.setAsManager(+event.id).take(1)
      .subscribe(([]) => this.operationDoneSubject.next(true));
  }

  onEmployeeRemoved(event: EmployeeListItem) {


    combineLatest(this.route.params.take(1), this.employeeService.deleteEmployee(+event.id).take(1))
      .subscribe(([]) => this.operationDoneSubject.next(true));
  }

  onEmployeeViewed(event: EmployeeListItem) {

  }

  onPageChanged(event: number) {

  }


}
