# Banking Credit Management System - Frontend

This project is the Angular-based frontend for the Banking Credit Management System developed as part of the JEE examination by Mohammed El Badry. It provides an intuitive interface for managing banking credits and client accounts.

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.2.11.

## Development server

To start a local development server, run:

```bash
ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Project Overview

This frontend application serves as the user interface for the Banking Credit Management System, allowing users to:

- Manage client profiles and credit applications
- Handle different types of credits (Personal, Real Estate, Professional)
- Track credit repayments and statuses
- Access role-based functionality (Client, Employee, Admin)

## Features

### User Authentication

- Secure JWT-based authentication
- Role-based access control

### Client Management

- Client profile creation and management
- Client credit history

### Credit Management

- Apply for different types of credits
- Track credit application status
- View credit details

### Repayment Management

- Manage repayment schedules
- Process repayment transactions

## Project Structure

The application follows a feature-based architecture:

- **Core**: Contains services, models, and interceptors
- **Features**: Feature modules for clients, credits, and dashboards
- **Shared**: Reusable components, directives, and pipes

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.

## Backend Integration

This frontend communicates with a Spring Boot backend API that provides:

- Client management endpoints
- Credit application processing
- Repayment management
- Authentication and authorization

API base URL can be configured in the environment files.

## Technologies Used

- **Angular**: Frontend framework
- **TypeScript**: Programming language
- **RxJS**: Reactive programming library
- **Angular Material**: UI component library (if used)
- **JWT**: Token-based authentication

## Contributors

- Mohammed El Badry
