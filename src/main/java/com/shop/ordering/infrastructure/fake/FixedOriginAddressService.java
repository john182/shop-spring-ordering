package com.shop.ordering.infrastructure.fake;

import com.shop.ordering.domain.model.service.OriginAddressService;
import com.shop.ordering.domain.model.valueobject.Address;
import com.shop.ordering.domain.model.valueobject.ZipCode;
import org.springframework.stereotype.Component;

@Component
public class FixedOriginAddressService implements OriginAddressService {

    @Override
    public Address originAddress() {
        return Address.builder()
                .street("Bourbon Street")
                .number("1134")
                .neighborhood("North Ville")
                .city("York")
                .state("South California")
                .zipCode(new ZipCode("12345"))
                .build();
    }
}
