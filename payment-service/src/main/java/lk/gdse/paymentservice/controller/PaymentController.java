package lk.gdse.paymentservice.controller;

import lk.gdse.paymentservice.ENUM.PaymentType;
import lk.gdse.paymentservice.dto.PaymentDTO;
import lk.gdse.paymentservice.service.PaymentService;
import lk.gdse.paymentservice.service.TicketServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TicketServiceClient ticketServiceClient;
    @GetMapping("/health")
    public String health(){
        return "Payment Service is Running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePayment(@RequestBody PaymentDTO paymentDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (!ticketServiceClient.isExitsTicket(paymentDTO.getTicketId())){
            return ResponseEntity.badRequest().body("Ticket not found");
        }
        paymentDTO.setPaymentDate(String.valueOf(LocalDate.now()));
        paymentService.savePayment(paymentDTO);
        return ResponseEntity.ok("Payment saved successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllPayment(){
        return ResponseEntity.ok(paymentService.getAllPayment());
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<?> getPayment(@PathVariable ("paymentId") String paymentId){
        return ResponseEntity.ok(paymentService.getPayment(paymentId));
    }
}
