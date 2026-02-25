package com.shop.ordering.domain.model.repository;

import com.shop.ordering.domain.model.entity.ShoppingCart;
import com.shop.ordering.domain.model.valueobject.id.CustomerId;
import com.shop.ordering.domain.model.valueobject.id.ShoppingCartId;

import java.util.Optional;

public interface ShoppingCarts extends RemoveCapableRepository<ShoppingCart, ShoppingCartId> {
	Optional<ShoppingCart> ofCustomer(CustomerId customerId);
}
