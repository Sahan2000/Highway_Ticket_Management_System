package lk.gdse.paymentservice.repository;

import lk.gdse.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServiceDao extends JpaRepository<Payment,String> {
}
