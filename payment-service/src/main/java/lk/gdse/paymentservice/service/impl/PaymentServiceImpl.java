package lk.gdse.paymentservice.service.impl;

import lk.gdse.paymentservice.conversion.ConversionData;
import lk.gdse.paymentservice.dto.PaymentDTO;
import lk.gdse.paymentservice.entity.Payment;
import lk.gdse.paymentservice.repository.PaymentServiceDao;
import lk.gdse.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentServiceDao paymentServiceDao;
    @Autowired
    private ConversionData conversionData;
    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        paymentServiceDao.save(conversionData.mapTo(paymentDTO, Payment.class));
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return conversionData.mapTo(paymentServiceDao.findAll(), PaymentDTO.class);
    }

    @Override
    public PaymentDTO getPayment(String paymentId) {
        return conversionData.mapTo(paymentServiceDao.findById(paymentId).get(), PaymentDTO.class);
    }
}
