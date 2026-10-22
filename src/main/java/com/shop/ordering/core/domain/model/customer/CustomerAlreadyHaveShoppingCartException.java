package com.shop.ordering.core.domain.model.customer;

import com.shop.ordering.core.domain.model.DomainException;
import com.shop.ordering.core.domain.model.ErrorMessages;

public class CustomerAlreadyHaveShoppingCartException extends DomainException {


    public CustomerAlreadyHaveShoppingCartException(CustomerId customerId) {
        super(String.format(ErrorMessages.ERROR_CUSTOMER_ALREADY_HAVE_SHOPPING_CART, customerId));
    }
}
