import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../shared/components/abstract-create-update-component/abstract-create-update.component";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Pet} from "../../models/pet.model";
import {getPetGenderEnumArr} from "../../../utilities/enum-utilities";
import {PetGenderEnum} from "../../../core/enums/pet.gender.enum";
import {OperationEnum} from "../../../core/enums/operation.enum";

@Component({
  selector: 'app-pet-create-update',
  templateUrl: './pet-create-update.component.html',
  styleUrls: ['./pet-create-update.component.css']
})
export class PetCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit, OnChanges {

  @Input()
  pet: Pet;
  formModel: FormGroup;
  @Output()
  petCreated = new EventEmitter<any>();
  @Output()
  petUpdated = new EventEmitter<any>();
  petGenderArr: [string, string][] = getPetGenderEnumArr();

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder) {
    super(route);
  }

  ngOnInit() {
    this.initForm();
  }
  setInitValue()
  {
    this.initForm();
  }

  invokeWhenCreate() {
    this.petCreated.emit(this.formModel.value);
    this.setInitValue();

  }

  invokeWhenUpdate() {
    this.petUpdated.emit(this.formModel.value);
    this.setInitValue();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['pet'] && this.pet) {
      this.operation = OperationEnum.UPDATE;
      this.inflateFormModelWithValues(this.pet);
    }
  }

  onGenderStatusClicked(status: string) {
    this.formModel.controls['gender'].setValue(status);
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'name': ['', Validators.required],
      'age': ['', Validators.required],
      'gender': ['',Validators.required],
      'color': [''],
      'species': [''],
      'petType':[''],
      'sterilized': ['']
    })
  }

  onChecked(event: boolean) {
    this.formModel.controls['sterilized'].setValue(event);
  }

  private inflateFormModelWithValues(pet: Pet) {
    this.formModel.controls['id'].setValue(pet.id);
    this.formModel.controls['name'].setValue(pet.name);
    this.formModel.controls['age'].setValue(pet.age);
    this.formModel.controls['gender'].setValue(pet.gender);
    this.formModel.controls['color'].setValue(pet.color);
    this.formModel.controls['species'].setValue(pet.species);
    this.formModel.controls['petType'].setValue(pet.petType);
    this.formModel.controls['sterilized'].setValue(pet.sterilized);
  }
}
