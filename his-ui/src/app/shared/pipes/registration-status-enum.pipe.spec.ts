import { RegistrationStatusEnumPipe } from './registration-status-enum.pipe';

describe('RegistrationStatusEnumPipe', () => {
  it('create an instance', () => {
    const pipe = new RegistrationStatusEnumPipe();
    expect(pipe).toBeTruthy();
  });
});
