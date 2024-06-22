package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import org.bamappli.ticketglob.Entities.Enum.Statut;
import org.bamappli.ticketglob.Entities.Ticket;
import org.bamappli.ticketglob.Services.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {
    TicketService ticketService;

    @GetMapping("/formateur/ticket/statut/{id}")
    public String updateStatut(@PathVariable Long id) {
        Ticket ticket = new Ticket();
        ticket.setStatut(Statut.EN_COURS);
        ticketService.updateTicketPartial(id, ticket);
        return "Statut Mise à Jour";
    }
}
