package lk.gdse.paymentservice.service;

import lk.gdse.paymentservice.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> getAllPayment();

    PaymentDTO getPayment(String paymentId);
}
