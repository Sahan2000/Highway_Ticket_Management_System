package lk.gdse.ticketservice.controller;

import lk.gdse.ticketservice.ENUM.TicketStatus;
import lk.gdse.ticketservice.dto.TicketDTO;
import lk.gdse.ticketservice.service.TicketService;
import lk.gdse.ticketservice.service.UserServiceClient;
import lk.gdse.ticketservice.service.VehicleServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    @Autowired
    private VehicleServiceClient vehicleServiceClient;
    @Autowired
    private UserServiceClient userServiceClient;
    @Autowired
    private TicketService ticketService;
    @GetMapping("/health")
    public String health(){
        return "Ticket Service is healthy";
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveTicket(@RequestBody TicketDTO ticketDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (!userServiceClient.isExitsUser(ticketDTO.getUserId())) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if (!vehicleServiceClient.isExitsVehicle(ticketDTO.getVehicleId())) {
            return ResponseEntity.badRequest().body("Vehicle not found");
        }
        ticketDTO.setTicketIssueDate(LocalDate.now());
        ticketDTO.setTicketStatus(TicketStatus.UNPAID);
        ticketService.saveTicket(ticketDTO);
        return ResponseEntity.ok("Ticket saved successfully");
    }

    @GetMapping(value = "/{ticketId}")
    public ResponseEntity<?> getTicket(@PathVariable ("ticketId") String ticketId){
        return ResponseEntity.ok(ticketService.getTicket(ticketId));
    }

    @GetMapping
    public ResponseEntity<?> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTicket(@RequestBody TicketDTO ticketDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (!userServiceClient.isExitsUser(ticketDTO.getUserId())) {
            return ResponseEntity.badRequest().body("User not found");
        }
        if (!vehicleServiceClient.isExitsVehicle(ticketDTO.getVehicleId())) {
            return ResponseEntity.badRequest().body("Vehicle not found");
        }
        ticketDTO.setTicketStatus(TicketStatus.UNPAID);
        ticketDTO.setTicketIssueDate(LocalDate.now());
        ticketService.updateTicket(ticketDTO);
        return ResponseEntity.ok("Ticket updated successfully");
    }

    @DeleteMapping(value = "/{ticketId}")
    public ResponseEntity<?> deleteTicket(@PathVariable ("ticketId") String ticketId){
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket deleted successfully");
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<?> getTicketsByUserId(@PathVariable ("userId") String userId){
        if (!userServiceClient.isExitsUser(userId)){
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok(ticketService.getTicketsByUserId(userId));
    }

    @GetMapping(value = "/vehicle/{vehicleId}")
    public ResponseEntity<?> getTicketByVehicleId(@PathVariable ("vehicleId") String vehicleId){
        if (!vehicleServiceClient.isExitsVehicle(vehicleId)){
            return ResponseEntity.badRequest().body("Vehicle not found");
        }
        return ResponseEntity.ok(ticketService.getTicketsByVehicleId(vehicleId));
    }
}
