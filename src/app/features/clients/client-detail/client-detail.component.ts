import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ClientService, CreditService } from '../../../core/services';
import { ClientDTO, CreditDTO } from '../../../core/models';

@Component({
  selector: 'app-client-detail',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './client-detail.component.html',
  styleUrl: './client-detail.component.css',
})
export class ClientDetailComponent implements OnInit {
  client?: ClientDTO;
  credits: CreditDTO[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private clientService: ClientService,
    private creditService: CreditService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const id = +params['id'];
      this.loadClient(id);
      this.loadClientCredits(id);
    });
  }

  loadClient(id: number): void {
    this.clientService.getClientById(id).subscribe((client) => {
      this.client = client;
    });
  }

  loadClientCredits(clientId: number): void {
    this.creditService.getCreditsByClientId(clientId).subscribe((credits) => {
      this.credits = credits;
    });
  }

  getStatusClass(statut: string): string {
    switch (statut) {
      case 'EN_ATTENTE':
        return 'status-en-attente';
      case 'ACCEPTE':
        return 'status-accepte';
      case 'REFUSE':
        return 'status-refuse';
      default:
        return '';
    }
  }

  goBack(): void {
    this.router.navigate(['/clients']);
  }
}
