package lk.gdse.paymentservice.repository;

import lk.gdse.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentServiceDao extends JpaRepository<Payment,String> {
}
