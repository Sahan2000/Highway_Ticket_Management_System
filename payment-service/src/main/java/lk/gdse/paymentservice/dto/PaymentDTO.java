package lk.gdse.paymentservice.dto;

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
    private String paymentId;
    private String paymentDate;
    private double amount;
    private String ticketId;
}
