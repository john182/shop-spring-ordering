package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.DomainException;
import com.shop.ordering.domain.model.ErrorMessages;
import com.shop.ordering.domain.model.product.ProductId;

public class ShoppingCartDoesNotContainProductException extends DomainException {
    public ShoppingCartDoesNotContainProductException(ShoppingCartId id, ProductId productId) {
        super(String.format(ErrorMessages.ERROR_SHOPPING_CART_DOES_NOT_CONTAIN_PRODUCT, id, productId));
    }
}
