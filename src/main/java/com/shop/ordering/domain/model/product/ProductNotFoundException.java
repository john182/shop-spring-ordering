package com.shop.ordering.domain.model.product;

import com.shop.ordering.domain.model.DomainException;
import com.shop.ordering.domain.model.ErrorMessages;

public class ProductNotFoundException extends DomainException {
    public ProductNotFoundException() {

    }

    public ProductNotFoundException(ProductId productId) {
        super(String.format(ErrorMessages.ERROR_PRODUCT_NOT_FOUND, productId));
    }

}
