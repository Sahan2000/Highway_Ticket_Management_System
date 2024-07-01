package lk.gdse.ticketservice.dto;

import lk.gdse.ticketservice.ENUM.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketDTO {
    private String ticketId;
    private LocalDate ticketIssueDate;
    private TicketStatus ticketStatus;
    private String vehicleId;
    private String userId;
}
