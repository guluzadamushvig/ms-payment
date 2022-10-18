package az.ingress.mspayment.client;

import az.ingress.mspayment.model.client.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-cards",url = "http://localhost:8082")
public interface CardClient {
    @PostMapping("/v1/cards")
    void saveCardTransaction(@RequestBody CardsDto cardsDto);
}
