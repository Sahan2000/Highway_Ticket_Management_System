package lk.gdse.ticketservice.repository;

import lk.gdse.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketServiceDao extends JpaRepository<Ticket, String> {
    List<Ticket> findAllByUserId(String userId);
    List<Ticket> findAllByVehicleId(String vehicleId);
}
