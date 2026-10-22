package com.shop.ordering.core.domain.model.shoppingcart;

import com.shop.ordering.core.domain.model.commons.Money;
import com.shop.ordering.core.domain.model.product.ProductId;

public interface ShoppingCartProductAdjustmentService {
    void adjustPrice(ProductId productId, Money updatedPrice);
    void changeAvailability(ProductId productId, boolean available);
}
