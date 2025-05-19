import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ClientService } from '../../../core/services';
import { ClientDTO } from '../../../core/models';

@Component({
  selector: 'app-client-list',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './client-list.component.html',
  styleUrl: './client-list.component.css',
})
export class ClientListComponent implements OnInit {
  clients: ClientDTO[] = [];
  searchKeyword = '';

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientService.getAllClients().subscribe((clients) => {
      this.clients = clients;
    });
  }

  searchClients(): void {
    if (this.searchKeyword.trim()) {
      this.clientService
        .searchClients(this.searchKeyword)
        .subscribe((clients) => {
          this.clients = clients;
        });
    } else {
      this.loadClients();
    }
  }

  deleteClient(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce client ?')) {
      this.clientService.deleteClient(id).subscribe(() => {
        this.clients = this.clients.filter((client) => client.id !== id);
      });
    }
  }
}
