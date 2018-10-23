import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../shared/components/abstract-create-update-component/abstract-create-update.component";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PetOwner} from "../../models/pet-owner.model";
import {GenderEnum} from "../../../core/enums/gender.enum";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";

@Component({
  selector: 'app-pet-owner-create-update',
  templateUrl: './pet-owner-create-update.component.html',
  styleUrls: ['./pet-owner-create-update.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class PetOwnerCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {


  @Input()
  petOwner: any;
  formModel: FormGroup;
  @Output()
  petOwnerCreated = new EventEmitter<any>();
  @Output()
  petOwnerUpdated = new EventEmitter<any>();
  genderStatusArr = [];
  selectedStatusText: string;
  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder) {
    super(route);

    this.initForm();
  }

  ngOnInit() {
    if(this.petOwner)
      this.formModel.patchValue(this.petOwner);
    this.getGenderStatusList();
  }


  invokeWhenCreate() {
    this.petOwnerCreated.emit(this.formModel.value);
    this.initForm();
    this.selectedStatusText = '';
  }

  invokeWhenUpdate() {
    this.petOwnerUpdated.emit(this.formModel.value);
    this.initForm();
    this.selectedStatusText = '';
  }


  getGenderStatusList() {

    this.genderStatusArr = Object.keys(GenderEnum).map(k => {
      return [k, GenderEnum[k as any]]
    });

  }

  onStatusClicked(status: string) {
    this.selectedStatusText = GenderEnum[status];
    this.formModel.controls['gender'].setValue(status);
  }

  onDateChanged(control: string, event: IMyDateModel) {
    if (event.formatted !== '') {
      this.formModel.controls[control].setValue(event.formatted);
    }
    else {
      this.formModel.controls[control].setValue("");
    }
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [],
      'name': ['', Validators.required],
      'gender': ['', Validators.required],
      'dateOfBirth': [''],
      'cellPhone': ['', Validators.required],
      'homePhone': [''],
      'email': [''],
      'address': ['']
    })
  }

  private inflateFormModelWithValues(petOwner: PetOwner) {

    this.formModel.controls['id'].setValue(petOwner.id);
    this.formModel.controls['name'].setValue(petOwner.name);
    this.formModel.controls['gender'].setValue(petOwner.gender);

    this.selectedStatusText = GenderEnum[petOwner.gender];

    this.formModel.controls['dateOfBirth'].setValue(petOwner.dateOfBirth);
    this.formModel.controls['cellPhone'].setValue(petOwner.cellPhone);
    this.formModel.controls['homePhone'].setValue(petOwner.homePhone);
    this.formModel.controls['email'].setValue(petOwner.email);
    this.formModel.controls['address'].setValue(petOwner.address);
  }



}
