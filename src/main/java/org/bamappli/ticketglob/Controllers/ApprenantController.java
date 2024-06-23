package org.bamappli.ticketglob.Controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Ticket;
import org.bamappli.ticketglob.Services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apprenant")
@Getter
@Setter
@AllArgsConstructor
public class ApprenantController {
    TicketService ticketService;

    @PostMapping("/tickets")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.creer(ticket);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTicket() {
        return ticketService.tout();
    }
    @GetMapping("/tickets/{id}")
    public Optional<Ticket> getOneTicket(@PathVariable Integer id) {
        return ticketService.unTicket(id);
    }

    @PutMapping("/tickets/{id}")
    public Ticket updateTicket(@PathVariable Integer id, @RequestBody Ticket ticket) {
        return ticketService.misAjour(id, ticket);
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable Integer id) {
        ticketService.effacer(id);
    }

}
