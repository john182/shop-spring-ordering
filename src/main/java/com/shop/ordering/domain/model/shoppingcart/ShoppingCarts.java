package com.shop.ordering.domain.model.shoppingcart;

import com.shop.ordering.domain.model.RemoveCapableRepository;
import com.shop.ordering.domain.model.customer.CustomerId;

import java.util.Optional;

public interface ShoppingCarts extends RemoveCapableRepository<ShoppingCart, ShoppingCartId> {
	Optional<ShoppingCart> ofCustomer(CustomerId customerId);
}
