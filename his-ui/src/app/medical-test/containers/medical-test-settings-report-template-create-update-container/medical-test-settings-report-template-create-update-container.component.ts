import {ChangeDetectionStrategy, Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {OperationEnum} from "../../../core/enums/operation.enum";

@Component({
  selector: 'app-medical-test-settings-report-template-create-update-container',
  templateUrl: './medical-test-settings-report-template-create-update-container.component.html',
  styleUrls: ['./medical-test-settings-report-template-create-update-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplateCreateUpdateContainerComponent {

  isCreate$: Observable<boolean>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
  ) {
    this.isCreate$ = this.route.params.map(params => {

      return params['operation'] === OperationEnum.CREATE;
    });
  }
}
