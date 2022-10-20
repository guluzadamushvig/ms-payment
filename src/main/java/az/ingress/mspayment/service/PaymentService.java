package az.ingress.mspayment.service;

import az.ingress.mspayment.client.CardClient;
import az.ingress.mspayment.dao.repository.PaymentRepository;
import az.ingress.mspayment.mapper.PaymentMapper;
import az.ingress.mspayment.model.PaymentRequest;
import az.ingress.mspayment.model.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.ingress.mspayment.mapper.PaymentMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private  final CardClient cardClient;
    public void savePayment(PaymentRequest paymentRequest) {
        log.info("ActionLog.SavePayment.Started");
        paymentRepository.save(PaymentRequestToPaymentEntity(paymentRequest));
        log.info("ActionLog.CallMSCard.Started");
        cardClient.saveCardTransaction(PaymentRequestToCardsDto(paymentRequest));
        log.info("ActionLog.CallMSCard.Finished");
        log.info("ActionLog.SavePayment.Finished");
    }

    public List<PaymentResponse> getPayments(){
        log.info("ActionLog.SavePayment.Started");
        var payments = paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::PaymentEntityToPaymentResponse)
                //.map(payment -> PaymentEntityToPaymentResponse(payment))
                .collect(Collectors.toList());
        log.info("ActionLog.SavePayment.Finished");
        return payments;
    }
}
