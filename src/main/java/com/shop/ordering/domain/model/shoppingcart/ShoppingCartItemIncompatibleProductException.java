package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.DomainException;
import com.shop.ordering.domain.model.ErrorMessages;
import com.shop.ordering.domain.model.product.ProductId;

public class ShoppingCartItemIncompatibleProductException extends DomainException {
    public ShoppingCartItemIncompatibleProductException(ShoppingCartItemId id, ProductId productId) {
        super(String.format(ErrorMessages.ERROR_SHOPPING_CART_ITEM_INCOMPATIBLE_PRODUCT, id, productId));
    }
}
