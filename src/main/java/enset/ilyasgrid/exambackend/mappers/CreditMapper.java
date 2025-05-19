package enset.ilyasgrid.exambackend.mappers;

import enset.ilyasgrid.exambackend.dtos.*;
import enset.ilyasgrid.exambackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public CreditDTO fromCredit(Credit credit) {
        CreditDTO creditDTO = new CreditDTO();
        BeanUtils.copyProperties(credit, creditDTO);
        creditDTO.setClientId(credit.getClient().getId());
        creditDTO.setClientNom(credit.getClient().getNom());
        return creditDTO;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier) {
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier, dto);
        dto.setClientId(creditImmobilier.getClient().getId());
        dto.setClientNom(creditImmobilier.getClient().getNom());
        return dto;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel) {
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(creditPersonnel, dto);
        dto.setClientId(creditPersonnel.getClient().getId());
        dto.setClientNom(creditPersonnel.getClient().getNom());
        return dto;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel creditProfessionnel) {
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(creditProfessionnel, dto);
        dto.setClientId(creditProfessionnel.getClient().getId());
        dto.setClientNom(creditProfessionnel.getClient().getNom());
        return dto;
    }

    public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, dto);
        dto.setCreditId(remboursement.getCredit().getId());
        dto.setClientNom(remboursement.getCredit().getClient().getNom());
        return dto;
    }
}