package org.bamappli.ticketglob.Repositories;

import org.bamappli.ticketglob.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("select t from Ticket t where t.id=:x")
    Ticket findByTicketId(@Param("x") Long ticketId);
}
