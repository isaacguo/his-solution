import { PetGenderEnumPipe } from './pet-gender-enum.pipe';

describe('PetGenderEnumPipe', () => {
  it('create an instance', () => {
    const pipe = new PetGenderEnumPipe();
    expect(pipe).toBeTruthy();
  });
});
