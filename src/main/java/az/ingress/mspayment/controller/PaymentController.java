package az.ingress.mspayment.controller;

import az.ingress.mspayment.model.PaymentRequest;
import az.ingress.mspayment.model.PaymentResponse;
import az.ingress.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePayment(@RequestBody PaymentRequest paymentRequest){
            paymentService.savePayment(paymentRequest);
    }

    @GetMapping
    public List<PaymentResponse> getPayments (){
        return paymentService.getPayments();
    }

}
