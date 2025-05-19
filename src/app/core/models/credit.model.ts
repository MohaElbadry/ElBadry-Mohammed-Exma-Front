export enum StatutCredit {
  EN_ATTENTE = 'EN_ATTENTE',
  ACCEPTE = 'ACCEPTE',
  REFUSE = 'REFUSE'
}

export interface CreditDTO {
  id?: number;
  dateDemande: Date;
  statut: StatutCredit;
  montant: number;
  duree: number;
  taux: number;
  clientId: number;
  clientNom: string;
}

export interface CreditImmobilierDTO extends CreditDTO {
  typeBien: TypeBien;
}

export enum TypeBien {
  APPARTEMENT = 'APPARTEMENT',
  MAISON = 'MAISON',
  TERRAIN = 'TERRAIN'
}

export interface CreditPersonnelDTO extends CreditDTO {
  motif: string;
}

export interface CreditProfessionnelDTO extends CreditDTO {
  motif: string;
  raisonSociale: string;
}
