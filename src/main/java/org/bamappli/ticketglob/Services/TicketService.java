package org.bamappli.ticketglob.Services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bamappli.ticketglob.Entities.Ticket;
import org.bamappli.ticketglob.Repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;

    public Ticket creer(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> tout(){
        return ticketRepository.findAll();
    }

        public Optional<Ticket> unTicket(Integer id){
        return ticketRepository.findById(id);
    }

    public Ticket misAjour(Integer id, @org.jetbrains.annotations.NotNull Ticket updateTicket){
        Optional<Ticket> existingTick = ticketRepository.findById(id);
        if(existingTick.isPresent()){
            Ticket existingTicket = existingTick.get();
            existingTicket.setTitre(updateTicket.getTitre());
            existingTicket.setDescription(updateTicket.getDescription());
            existingTicket.setApprenant(updateTicket.getApprenant());
            ticketRepository.save(existingTicket);
        }
        return existingTick.orElse(null);
    }

    public void effacer(Integer id){
        ticketRepository.deleteById(id);
    }

}
