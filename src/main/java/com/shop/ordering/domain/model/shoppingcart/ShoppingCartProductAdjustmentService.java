package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.commons.Money;
import com.shop.ordering.domain.model.product.ProductId;

public interface ShoppingCartProductAdjustmentService {
    void adjustPrice(ProductId productId, Money updatedPrice);
    void changeAvailability(ProductId productId, boolean available);
}
