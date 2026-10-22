package com.shop.ordering.core.domain.model.shoppingcart;

import com.shop.ordering.core.domain.model.customer.CustomerId;
import com.shop.ordering.core.domain.model.product.ProductId;

import java.time.OffsetDateTime;

public record ShoppingCartItemAddedEvent(
    ShoppingCartId shoppingCartId,
    CustomerId customerId,
    ProductId productId,
    OffsetDateTime addedAt
) {}
