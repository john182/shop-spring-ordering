package com.shop.ordering.infrastructure.adapters.out.web.shipping.client.fake;

import com.shop.ordering.core.domain.model.order.shipping.ShippingCostService;
import com.shop.ordering.core.domain.model.commons.Money;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@ConditionalOnProperty(name = "shop.integrations.shipping.provider", havingValue = "FAKE")
public class ShippingCostServiceFakeImpl implements ShippingCostService {
    @Override
    public CalculationResult calculate(CalculationRequest request) {
        return new CalculationResult(
                new Money("20"),
                LocalDate.now().plusDays(5)
        );
    }
}
