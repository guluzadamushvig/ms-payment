package az.ingress.mspayment.model.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardsDto {
    private BigDecimal amount;
    private String cardholder;
    private Long card_number;
    private LocalDateTime last_transaction_date;
}
