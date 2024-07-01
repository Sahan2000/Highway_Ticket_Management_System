package lk.gdse.ticketservice.repository;

import lk.gdse.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketServiceDao extends JpaRepository<Ticket, String> {
}
