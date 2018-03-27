import {OperationEnum} from "../../enums/operation.enum";
import {ActivatedRoute} from "@angular/router";

export abstract class AbstractCreateUpdateComponent {

  public operation: OperationEnum = OperationEnum.CREATE;
  public updateId: number;

  constructor(public  route: ActivatedRoute) {

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
