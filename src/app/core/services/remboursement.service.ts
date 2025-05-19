import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiService } from './api.service';
import { RemboursementDTO, TypeRemboursement } from '../models';

@Injectable({
  providedIn: 'root'
})
export class RemboursementService {
  private path = '/remboursements';

  constructor(private apiService: ApiService) { }

  getAllRemboursements(): Observable<RemboursementDTO[]> {
    return this.apiService.get<RemboursementDTO[]>(this.path);
  }

  getRemboursementById(id: number): Observable<RemboursementDTO> {
    return this.apiService.get<RemboursementDTO>(`${this.path}/${id}`);
  }

  getRemboursementsByCreditId(creditId: number): Observable<RemboursementDTO[]> {
    const params = new HttpParams().set('creditId', creditId.toString());
    return this.apiService.get<RemboursementDTO[]>(`${this.path}/credit`, params);
  }

  getRemboursementsByType(type: TypeRemboursement): Observable<RemboursementDTO[]> {
    const params = new HttpParams().set('type', type);
    return this.apiService.get<RemboursementDTO[]>(`${this.path}/type`, params);
  }

  getRemboursementsByDateRange(startDate: Date, endDate: Date): Observable<RemboursementDTO[]> {
    const params = new HttpParams()
      .set('startDate', startDate.toISOString())
      .set('endDate', endDate.toISOString());
    return this.apiService.get<RemboursementDTO[]>(`${this.path}/date-range`, params);
  }

  createRemboursement(remboursement: RemboursementDTO): Observable<RemboursementDTO> {
    return this.apiService.post<RemboursementDTO, RemboursementDTO>(this.path, remboursement);
  }

  updateRemboursement(remboursement: RemboursementDTO): Observable<RemboursementDTO> {
    return this.apiService.put<RemboursementDTO, RemboursementDTO>(`${this.path}/${remboursement.id}`, remboursement);
  }

  deleteRemboursement(id: number): Observable<void> {
    return this.apiService.delete<void>(`${this.path}/${id}`);
  }
}
