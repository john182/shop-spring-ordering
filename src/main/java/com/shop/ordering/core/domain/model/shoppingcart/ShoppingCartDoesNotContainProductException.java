package com.shop.ordering.core.domain.model.shoppingcart;

import com.shop.ordering.core.domain.model.DomainException;
import com.shop.ordering.core.domain.model.ErrorMessages;
import com.shop.ordering.core.domain.model.product.ProductId;

public class ShoppingCartDoesNotContainProductException extends DomainException {
    public ShoppingCartDoesNotContainProductException(ShoppingCartId id, ProductId productId) {
        super(String.format(ErrorMessages.ERROR_SHOPPING_CART_DOES_NOT_CONTAIN_PRODUCT, id, productId));
    }
}
