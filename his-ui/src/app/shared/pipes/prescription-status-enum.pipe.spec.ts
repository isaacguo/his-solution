import { PrescriptionStatusEnumPipe } from './prescription-status-enum.pipe';

describe('PrescriptionStatusEnumPipe', () => {
  it('create an instance', () => {
    const pipe = new PrescriptionStatusEnumPipe();
    expect(pipe).toBeTruthy();
  });
});
