package lk.gdse.paymentservice.service.impl;

import lk.gdse.paymentservice.service.TicketServiceClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TicketServiceClientImpl implements TicketServiceClient {
    private static final Logger logger = LoggerFactory.getLogger(TicketServiceClientImpl.class);
    private final RestTemplate restTemplate;
    @Override
    public boolean isExitsTicket(String id) {
        try {
            String url = "http://ticket-service/api/v1/ticket/ticketExists/" + id;
            Boolean userExists = restTemplate.getForObject(url, Boolean.class);
            logger.info("Ticket Exists: {}", userExists);
            return userExists != null && userExists;
        } catch (Exception e) {
            logger.error("Error checking if ticket exists", e);
        }
        return false;
    }
}
