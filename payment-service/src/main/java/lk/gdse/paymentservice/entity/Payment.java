package lk.gdse.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.gdse.paymentservice.ENUM.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment {
    @Id
    private String paymentId;
    private String paymentDate;
    private double amount;
    private String ticketId;
}
