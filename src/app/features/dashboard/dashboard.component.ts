import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  ClientService,
  CreditService,
  RemboursementService,
} from '../../core/services';
import { StatutCredit } from '../../core/models';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css',
})
export class DashboardComponent implements OnInit {
  clientCount = 0;
  creditCount = 0;
  remboursementCount = 0;
  creditEnAttenteCount = 0;
  creditAccepteCount = 0;
  creditRefuseCount = 0;

  constructor(
    private clientService: ClientService,
    private creditService: CreditService,
    private remboursementService: RemboursementService
  ) {}

  ngOnInit(): void {
    this.loadStats();
  }

  loadStats(): void {
    // Dans une application réelle, ces données viendraient de l'API
    // Pour l'instant, nous utilisons des valeurs fictives
    this.clientService.getAllClients().subscribe((clients) => {
      this.clientCount = clients.length;
    });

    this.creditService.getAllCredits().subscribe((credits) => {
      this.creditCount = credits.length;

      // Compter les crédits par statut
      this.creditEnAttenteCount = credits.filter(
        (c) => c.statut === StatutCredit.EN_ATTENTE
      ).length;
      this.creditAccepteCount = credits.filter(
        (c) => c.statut === StatutCredit.ACCEPTE
      ).length;
      this.creditRefuseCount = credits.filter(
        (c) => c.statut === StatutCredit.REFUSE
      ).length;
    });

    this.remboursementService
      .getAllRemboursements()
      .subscribe((remboursements) => {
        this.remboursementCount = remboursements.length;
      });
  }
}
