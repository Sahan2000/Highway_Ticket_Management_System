package lk.gdse.ticketservice.service.impl;

import lk.gdse.ticketservice.ENUM.TicketStatus;
import lk.gdse.ticketservice.conversion.ConversionData;
import lk.gdse.ticketservice.dto.TicketDTO;
import lk.gdse.ticketservice.entity.Ticket;
import lk.gdse.ticketservice.repository.TicketServiceDao;
import lk.gdse.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketServiceDao ticketRepository;
    @Autowired
    private ConversionData conversionData;
    @Override
    public void saveTicket(TicketDTO ticketDTO) {
        ticketRepository.save(conversionData.mapTo(ticketDTO, Ticket.class));
    }

    @Override
    public TicketDTO getTicket(String ticketId) {
        return conversionData.mapTo(ticketRepository.findById(ticketId).get(), TicketDTO.class);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return conversionData.mapTo(ticketRepository.findAll(), TicketDTO.class);
    }

    @Override
    public void updateTicket(TicketDTO ticketDTO) {
        if (!ticketRepository.existsById(ticketDTO.getTicketId())){
            return;
        }
        ticketRepository.save(conversionData.mapTo(ticketDTO, Ticket.class));
    }

    @Override
    public List<TicketDTO> getTicketsByUserId(String userId) {
        List<TicketDTO> tickeDTOs = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findAllByUserId(userId);
        for (Ticket ticket : tickets) {
            tickeDTOs.add(conversionData.mapTo(ticket, TicketDTO.class));
        }
        return tickeDTOs;
    }

    @Override
    public List<TicketDTO> getTicketsByVehicleId(String vehicleId) {
        List<TicketDTO> tickeDTOs = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findAllByVehicleId(vehicleId);
        for (Ticket ticket : tickets) {
            tickeDTOs.add(conversionData.mapTo(ticket, TicketDTO.class));
        }
        return tickeDTOs;
    }

    @Override
    public boolean isTicketExists(String ticketId) {
        if (ticketRepository.existsById(ticketId)){
            TicketDTO ticket = getTicket(ticketId);
            ticket.setTicketStatus(TicketStatus.PAID);
            updateTicket(ticket);
            return true;
        }
        return false;
    }
}
