export enum TypeRemboursement {
  MENSUEL = 'MENSUEL',
  TRIMESTRIEL = 'TRIMESTRIEL',
  SEMESTRIEL = 'SEMESTRIEL',
  ANNUEL = 'ANNUEL'
}

export interface RemboursementDTO {
  id?: number;
  date: Date;
  montant: number;
  type: TypeRemboursement;
  creditId: number;
  clientNom: string;
}
