import {ActivatedRoute} from "@angular/router";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {Input} from "@angular/core";

export abstract class AbstractCreateUpdateComponent {

  @Input()
  set isCreate(mode:boolean){
    this.operation=mode?OperationEnum.CREATE:OperationEnum.UPDATE;
  }

  public operation: OperationEnum = OperationEnum.CREATE;
  public updateId: any;

  constructor(public route: ActivatedRoute) {

  }

  getOperationText() {
    return this.operation === OperationEnum.CREATE ? "创建" : "修改";
  }

  isCreateMode():boolean
  {
    return this.operation===OperationEnum.CREATE;
  }
  abstract invokeWhenCreate();
  abstract invokeWhenUpdate();
  onSubmit() {
    if (this.operation === OperationEnum.CREATE) {
      this.invokeWhenCreate();
    }
    else {
      this.invokeWhenUpdate();
    }
  }

  protected process() {
    this.route.params.take(1).subscribe(params => {
      this.operation = OperationEnum[<string>params['operation']];
      if(this.operation===OperationEnum.UPDATE) {
        console.log('true');
        this.updateId = params['updateId'];
      }
    });
  }
}
