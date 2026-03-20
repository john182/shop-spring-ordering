package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.customer.CustomerId;

import java.time.OffsetDateTime;

public record ShoppingCartCreatedEvent(
    ShoppingCartId shoppingCartId,
    CustomerId customerId,
    OffsetDateTime createdAt
) {}
