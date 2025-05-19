# Rapport de Projet : Application de Gestion de Crédits Bancaires

## Introduction

Ce rapport présente le développement d'une application de gestion de crédits bancaires réalisée avec Angular 19 pour le frontend et Spring Boot pour le backend. L'application permet de gérer les clients, différents types de crédits (immobilier, personnel, professionnel) et les remboursements.

## Technologies Utilisées

- **Frontend** : Angular 19
- **UI Components** : Angular Material / PrimeNG
- **Formulaires** : Reactive Forms
- **Backend** : Spring Boot REST API
- **Communication** : HTTP Client

## Architecture du Projet

L'application suit une architecture modulaire avec séparation des responsabilités :

```
src/
├── app/
│   ├── core/                 # Services, intercepteurs, modèles
│   │   ├── services/         # Services HTTP pour l'API
│   │   ├── interceptors/     # Intercepteurs HTTP
│   │   └── models/           # Interfaces pour les modèles de données
│   ├── shared/               # Composants partagés
│   └── features/             # Modules fonctionnels
│       ├── dashboard/        # Tableau de bord
│       ├── clients/          # Gestion des clients
│       ├── credits/          # Gestion des crédits
│       └── remboursements/   # Gestion des remboursements
```

## Fonctionnalités Principales

### 1. Gestion des Clients

- Affichage de la liste des clients
- Ajout, modification et suppression de clients
- Recherche de clients par mot-clé
- Affichage des détails d'un client

### 2. Gestion des Crédits

- Vue d'ensemble de tous les crédits
- Gestion spécifique pour chaque type de crédit (immobilier, personnel, professionnel)
- Filtrage des crédits par statut (EN_ATTENTE, ACCEPTE, REFUSE)
- Affichage des crédits par client

### 3. Gestion des Remboursements

- Suivi des remboursements pour chaque crédit
- Ajout et modification de remboursements
- Filtrage par type de remboursement (MENSUEL, TRIMESTRIEL, SEMESTRIEL, ANNUEL)

### 4. Tableau de Bord

- Statistiques sur les crédits (montants, statuts)
- Indicateurs de performance

## Captures d'écran

### Page d'accueil / Tableau de bord
![Dashboard](screenshots/dashboard.png)

### Liste des clients
![Liste des clients](screenshots/client-list.png)

### Détails d'un client
![Détails d'un client](screenshots/client-detail.png)

### Formulaire d'ajout/modification de client
![Formulaire client](screenshots/client-form.png)

## Points forts du projet

1. **Architecture modulaire** : Séparation claire des responsabilités
2. **Code propre et maintenable** : Séparation du HTML, CSS et TypeScript
3. **Interface utilisateur intuitive** : Navigation simple et design responsive
4. **Formulaires réactifs** : Validation des données côté client
5. **Communication avec l'API** : Utilisation efficace des services HTTP

## Améliorations futures

1. Implémentation de l'authentification et de l'autorisation
2. Ajout de graphiques plus détaillés dans le tableau de bord
3. Amélioration de la gestion des erreurs
4. Ajout de tests unitaires et d'intégration
5. Optimisation des performances

## Conclusion

Ce projet démontre la mise en œuvre d'une application web moderne pour la gestion de crédits bancaires. L'utilisation d'Angular pour le frontend offre une interface utilisateur réactive et intuitive, tandis que l'API REST Spring Boot fournit un backend robuste et évolutif.

L'architecture modulaire et la séparation des responsabilités facilitent la maintenance et l'évolution future de l'application.
