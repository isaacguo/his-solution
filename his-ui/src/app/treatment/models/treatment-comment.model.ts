export interface TreatmentCaseComment {
  readonly treatmentCaseUuid?: number,
  readonly content?: string;

  readonly comments?: string;
  readonly createdDate?: Date;
}
