import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientService } from '../../../core/services';
import { ClientDTO } from '../../../core/models';

@Component({
  selector: 'app-client-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './client-form.component.html',
  styleUrl: './client-form.component.css',
})
export class ClientFormComponent implements OnInit {
  clientForm!: FormGroup;
  isEditMode = false;
  clientId?: number;

  constructor(
    private fb: FormBuilder,
    private clientService: ClientService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.initForm();

    // Vérifier si nous sommes en mode édition
    this.route.params.subscribe((params) => {
      if (params['id'] && params['id'] !== 'new') {
        this.isEditMode = true;
        this.clientId = +params['id'];
        this.loadClient(this.clientId);
      }
    });
  }

  initForm(): void {
    this.clientForm = this.fb.group({
      nom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
    });
  }

  loadClient(id: number): void {
    this.clientService.getClientById(id).subscribe((client) => {
      this.clientForm.patchValue({
        nom: client.nom,
        email: client.email,
      });
    });
  }

  onSubmit(): void {
    if (this.clientForm.invalid) {
      return;
    }

    const clientData: ClientDTO = {
      ...this.clientForm.value,
    };

    if (this.isEditMode && this.clientId) {
      clientData.id = this.clientId;
      this.clientService.updateClient(clientData).subscribe(() => {
        this.router.navigate(['/clients']);
      });
    } else {
      this.clientService.createClient(clientData).subscribe(() => {
        this.router.navigate(['/clients']);
      });
    }
  }

  cancel(): void {
    this.router.navigate(['/clients']);
  }
}
