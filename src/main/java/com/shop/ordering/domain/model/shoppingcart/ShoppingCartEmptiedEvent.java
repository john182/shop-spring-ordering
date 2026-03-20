package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.customer.CustomerId;

import java.time.OffsetDateTime;

public record ShoppingCartEmptiedEvent(
    ShoppingCartId shoppingCartId,
    CustomerId customerId,
    OffsetDateTime emptiedAt
) {}
