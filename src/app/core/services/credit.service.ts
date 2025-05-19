import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { 
  CreditDTO, 
  CreditImmobilierDTO, 
  CreditPersonnelDTO, 
  CreditProfessionnelDTO, 
  StatutCredit 
} from '../models';

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  private basePath = '/credits';
  private immobilierPath = '/credits/immobilier';
  private personnelPath = '/credits/personnel';
  private professionnelPath = '/credits/professionnel';

  constructor(private apiService: ApiService) { }

  // Méthodes génériques pour tous les crédits
  getAllCredits(): Observable<CreditDTO[]> {
    return this.apiService.get<CreditDTO[]>(this.basePath);
  }

  getCreditById(id: number): Observable<CreditDTO> {
    return this.apiService.get<CreditDTO>(`${this.basePath}/${id}`);
  }

  getCreditsByClientId(clientId: number): Observable<CreditDTO[]> {
    const params = new HttpParams().set('clientId', clientId.toString());
    return this.apiService.get<CreditDTO[]>(`${this.basePath}/client`, params);
  }

  getCreditsByStatut(statut: StatutCredit): Observable<CreditDTO[]> {
    const params = new HttpParams().set('statut', statut);
    return this.apiService.get<CreditDTO[]>(`${this.basePath}/statut`, params);
  }

  // Méthodes pour les crédits immobiliers
  getAllCreditsImmobilier(): Observable<CreditImmobilierDTO[]> {
    return this.apiService.get<CreditImmobilierDTO[]>(this.immobilierPath);
  }

  getCreditImmobilierById(id: number): Observable<CreditImmobilierDTO> {
    return this.apiService.get<CreditImmobilierDTO>(`${this.immobilierPath}/${id}`);
  }

  createCreditImmobilier(credit: CreditImmobilierDTO): Observable<CreditImmobilierDTO> {
    return this.apiService.post<CreditImmobilierDTO, CreditImmobilierDTO>(this.immobilierPath, credit);
  }

  updateCreditImmobilier(credit: CreditImmobilierDTO): Observable<CreditImmobilierDTO> {
    return this.apiService.put<CreditImmobilierDTO, CreditImmobilierDTO>(`${this.immobilierPath}/${credit.id}`, credit);
  }

  // Méthodes pour les crédits personnels
  getAllCreditsPersonnel(): Observable<CreditPersonnelDTO[]> {
    return this.apiService.get<CreditPersonnelDTO[]>(this.personnelPath);
  }

  getCreditPersonnelById(id: number): Observable<CreditPersonnelDTO> {
    return this.apiService.get<CreditPersonnelDTO>(`${this.personnelPath}/${id}`);
  }

  createCreditPersonnel(credit: CreditPersonnelDTO): Observable<CreditPersonnelDTO> {
    return this.apiService.post<CreditPersonnelDTO, CreditPersonnelDTO>(this.personnelPath, credit);
  }

  updateCreditPersonnel(credit: CreditPersonnelDTO): Observable<CreditPersonnelDTO> {
    return this.apiService.put<CreditPersonnelDTO, CreditPersonnelDTO>(`${this.personnelPath}/${credit.id}`, credit);
  }

  // Méthodes pour les crédits professionnels
  getAllCreditsProfessionnel(): Observable<CreditProfessionnelDTO[]> {
    return this.apiService.get<CreditProfessionnelDTO[]>(this.professionnelPath);
  }

  getCreditProfessionnelById(id: number): Observable<CreditProfessionnelDTO> {
    return this.apiService.get<CreditProfessionnelDTO>(`${this.professionnelPath}/${id}`);
  }

  createCreditProfessionnel(credit: CreditProfessionnelDTO): Observable<CreditProfessionnelDTO> {
    return this.apiService.post<CreditProfessionnelDTO, CreditProfessionnelDTO>(this.professionnelPath, credit);
  }

  updateCreditProfessionnel(credit: CreditProfessionnelDTO): Observable<CreditProfessionnelDTO> {
    return this.apiService.put<CreditProfessionnelDTO, CreditProfessionnelDTO>(`${this.professionnelPath}/${credit.id}`, credit);
  }

  // Méthode générique pour supprimer un crédit
  deleteCredit(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.basePath}/${id}`);
  }
}
