package com.shop.ordering.domain.model.exception;

import com.shop.ordering.domain.model.valueobject.id.ProductId;

public class ProductOutOfStockException extends DomainException {

    public ProductOutOfStockException(ProductId id) {
        super(String.format(ErrorMessages.ERROR_PRODUCT_IS_OUT_OF_STOCK, id));
    }
}
