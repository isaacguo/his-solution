import {MyTreeNode} from "../../../dto/procurement/MyTreeNode";
import {Observable} from "../../../../../node_modules/rxjs";

export interface CategoryService {

  getNodes(): Observable<MyTreeNode[]>;

  deleteOne(categoryId: number ): any;

  update(categoryId: number , value: any): any;

  create(param:any): any;
}
