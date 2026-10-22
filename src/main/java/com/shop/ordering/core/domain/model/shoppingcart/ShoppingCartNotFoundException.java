package com.shop.ordering.core.domain.model.shoppingcart;

import com.shop.ordering.core.domain.model.DomainException;

import java.util.UUID;

public class ShoppingCartNotFoundException extends DomainException {


    public ShoppingCartNotFoundException(UUID shoppingCartId) {
        this("Shopping cart with ID " + shoppingCartId + " not found.");
    }

    public ShoppingCartNotFoundException(String message) {
        super(message);
    }

    public static ShoppingCartNotFoundException ofCustomer(UUID customerId) {
        return new ShoppingCartNotFoundException("Shopping cart for customer ID " + customerId + " not found.");
    }
}
