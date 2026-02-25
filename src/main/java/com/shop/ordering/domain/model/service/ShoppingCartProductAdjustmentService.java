package com.shop.ordering.domain.model.service;

import com.shop.ordering.domain.model.valueobject.Money;
import com.shop.ordering.domain.model.valueobject.id.ProductId;

public interface ShoppingCartProductAdjustmentService {
    void adjustPrice(ProductId productId, Money updatedPrice);
    void changeAvailability(ProductId productId, boolean available);
}
