import {PetGenderEnum} from "../core/enums/pet.gender.enum";
import {YesNoEnum} from "../core/enums/yes-no.enum";
import {RegistrationStatusEnum} from "../core/enums/registration-status.enum";

export function getPetGenderEnumArr(): [string, string][] {
  let arr = [];
  arr = Object.keys(PetGenderEnum).map(k => {
    return [k, PetGenderEnum[k as any]]
  });
  return arr;
}

export function getSterilizedEnumArr(): [string, string][] {
  let arr = [];
  arr = Object.keys(YesNoEnum).map(k => {
    return [k, YesNoEnum[k as any]]
  });
  return arr;
}

export function getRegistrationStatusArr(): [string, string][] {
  let arr = [];
  arr = Object.keys(RegistrationStatusEnum).map(k => {
    return [k, RegistrationStatusEnum[k as any]]
  });
  return arr;
}


