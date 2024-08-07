package lk.gdse.ticketservice.service;

import lk.gdse.ticketservice.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    void saveTicket(TicketDTO ticketDTO);

    TicketDTO getTicket(String ticketId);

    List<TicketDTO> getAllTickets();

    void updateTicket(TicketDTO ticketDTO);

    List<TicketDTO> getTicketsByUserId(String userId);

    List<TicketDTO> getTicketsByVehicleId(String vehicleId);

    boolean isTicketExists(String ticketId);
}
