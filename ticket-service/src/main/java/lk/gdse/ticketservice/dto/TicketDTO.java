package lk.gdse.ticketservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    @Null(message = "Id generate by  program")
    private String ticketId;
    @NotNull(message = "ticket issue date cannot be a null")
    private LocalDate ticketIssueDate;
    private TicketStatus ticketStatus;
    private String vehicleId;
    private String userId;
}
