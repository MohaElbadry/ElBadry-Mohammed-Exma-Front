package enset.ilyasgrid.exambackend;

import enset.ilyasgrid.exambackend.entities.*;
import enset.ilyasgrid.exambackend.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class ExamBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            ClientRepository clientRepository,
            CreditRepository creditRepository,
            CreditImmobilierRepository creditImmobilierRepository,
            CreditPersonnelRepository creditPersonnelRepository,
            CreditProfessionnelRepository creditProfessionnelRepository,
            RemboursementRepository remboursementRepository
    ) {
        return args -> {
            System.out.println("=== Initialisation de la base de données ===");
            
            // Création de clients
            Client client1 = new Client();
            client1.setNom("Ahmed");
            client1.setEmail("ahmed.alami@gmail.com");
            clientRepository.save(client1);
            
            Client client2 = new Client();
            client2.setNom("Fatima");
            client2.setEmail("fatima@gmail.com");
            clientRepository.save(client2);
            
            Client client3 = new Client();
            client3.setNom("Karim");
            client3.setEmail("karim@gmail.com");
            clientRepository.save(client3);
            
            System.out.println("Clients créés: " + clientRepository.count());
            
            // Création de crédits immobiliers
            CreditImmobilier creditImmo = new CreditImmobilier();
            creditImmo.setClient(client1);
            creditImmo.setDateDemande(new Date());
            creditImmo.setMontant(new BigDecimal("800000.00"));
            creditImmo.setDuree(240); // 20 ans
            creditImmo.setTaux(4.5);
            creditImmo.setStatut(StatutCredit.ACCEPTE);
            creditImmo.setTypeBien(TypeBien.APPARTEMENT);
            creditImmobilierRepository.save(creditImmo);
            
            // Création de crédits personnels
            CreditPersonnel creditPerso = new CreditPersonnel();
            creditPerso.setClient(client2);
            creditPerso.setDateDemande(new Date());
            creditPerso.setMontant(new BigDecimal("50000.00"));
            creditPerso.setDuree(36); // 3 ans
            creditPerso.setTaux(7.5);
            creditPerso.setStatut(StatutCredit.ACCEPTE);
            creditPerso.setMotif("Achat de voiture");
            creditPersonnelRepository.save(creditPerso);
            
            // Création de crédits professionnels
            CreditProfessionnel creditPro = new CreditProfessionnel();
            creditPro.setClient(client3);
            creditPro.setDateDemande(new Date());
            creditPro.setMontant(new BigDecimal("300000.00"));
            creditPro.setDuree(60); // 5 ans
            creditPro.setTaux(6.0);
            creditPro.setStatut(StatutCredit.EN_ATTENTE);
            creditPro.setMotif("Expansion d'entreprise");
            creditPro.setRaisonSociale("Idrissi Tech SARL");
            creditProfessionnelRepository.save(creditPro);
            
            System.out.println("Crédits créés: " + creditRepository.count());
            
            // Création de remboursements
            Remboursement remb1 = new Remboursement();
            remb1.setCredit(creditImmo);
            remb1.setDate(new Date());
            remb1.setMontant(new BigDecimal("4500.00"));
            remb1.setType(TypeRemboursement.MENSUEL);
            remboursementRepository.save(remb1);
            
            Remboursement remb2 = new Remboursement();
            remb2.setCredit(creditPerso);
            remb2.setDate(new Date());
            remb2.setMontant(new BigDecimal("1500.00"));
            remb2.setType(TypeRemboursement.MENSUEL);
            remboursementRepository.save(remb2);
            
            System.out.println("Remboursements créés: " + remboursementRepository.count());
            

            

            
//            System.out.println("Crédits acceptés:");
//            creditRepository.findByStatut(StatutCredit.ACCEPTE).forEach(c ->
//                System.out.println(" - Client: " + c.getClient().getNom() + ", Montant: " + c.getMontant()));
//
//            System.out.println("Crédits immobiliers de type APPARTEMENT:");
//            creditImmobilierRepository.findByTypeBien(TypeBien.APPARTEMENT).forEach(c ->
//                System.out.println(" - Client: " + c.getClient().getNom() + ", Montant: " + c.getMontant()));
//
//            System.out.println("Crédits personnels pour achat de voiture:");
//            creditPersonnelRepository.findByMotifContaining("voiture").forEach(c ->
//                System.out.println(" - Client: " + c.getClient().getNom() + ", Montant: " + c.getMontant()));
            
//            System.out.println("Remboursements mensuels:");
//            remboursementRepository.findByType(TypeRemboursement.MENSUEL).forEach(r ->
//                System.out.println(" - Client: " + r.getCredit().getClient().getNom() + ", Montant: " + r.getMontant()));
        };
    }
}
