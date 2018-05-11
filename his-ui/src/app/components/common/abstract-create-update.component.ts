import {OperationEnum} from "../../enums/operation.enum";
import {ActivatedRoute} from "@angular/router";

export abstract class AbstractCreateUpdateComponent {

  public operation: OperationEnum = OperationEnum.CREATE;
  public updateId: any;

  constructor(public  route: ActivatedRoute) {

  }

  getOperationText() {
    return this.operation === OperationEnum.CREATE ? "创建" : "修改";
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
    this.route.params.subscribe(params => {
      this.operation = OperationEnum[<string>params['operation']];
      if(this.operation===OperationEnum.UPDATE) {
        this.updateId = params['updateId'];
      }
    });
  }
}
