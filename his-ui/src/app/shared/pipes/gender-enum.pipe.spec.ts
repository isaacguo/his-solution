import { GenderEnumPipe } from './gender-enum.pipe';

describe('GenderEnumPipe', () => {
  it('create an instance', () => {
    const pipe = new GenderEnumPipe();
    expect(pipe).toBeTruthy();
  });
});
