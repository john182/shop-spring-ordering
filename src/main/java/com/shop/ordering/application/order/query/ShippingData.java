package com.shop.ordering.application.order.query;

import com.shop.ordering.application.checkout.RecipientData;
import com.shop.ordering.application.commons.AddressData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingData {
    private BigDecimal cost;
    private LocalDate expectedDate;
    private RecipientData recipient;
    private AddressData address;
}
