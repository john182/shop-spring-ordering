package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.customer.CustomerId;
import com.shop.ordering.domain.model.product.ProductId;

import java.time.OffsetDateTime;

public record ShoppingCartItemRemovedEvent(
    ShoppingCartId shoppingCartId,
    CustomerId customerId,
    ProductId productId,
    OffsetDateTime removedAt
) {}
