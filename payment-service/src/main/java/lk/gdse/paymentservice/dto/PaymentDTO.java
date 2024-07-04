package lk.gdse.paymentservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lk.gdse.paymentservice.ENUM.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentDTO {
    @Null(message = "Id generate by  program")
    private String paymentId;
    @NotNull(message = "payment date cannot be a null")
    private String paymentDate;
    @NotNull(message = "amount cannot be a null")
    private double amount;
    private String ticketId;
}
