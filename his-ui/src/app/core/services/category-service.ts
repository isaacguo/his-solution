import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../core/models/my-tree-node.model";

export interface CategoryService {

  getNodes(): Observable<MyTreeNode[]>;

  deleteOne(categoryId: number ): any;

  update(categoryId: number , value: any): any;

  create(param:any): any;
}
