package com.shop.ordering.core.application.shoppingcart;

import com.shop.ordering.core.ports.in.shoppingcart.ForQueryingShoppingCarts;
import com.shop.ordering.core.ports.in.shoppingcart.ShoppingCartOutput;
import com.shop.ordering.core.ports.out.shoppingcart.ForObtainingShoppingCarts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingCartQueryService implements ForQueryingShoppingCarts {

    private final ForObtainingShoppingCarts forObtainingShoppingCarts;

    @Override
    public ShoppingCartOutput findById(UUID shoppingCartId) {
        return forObtainingShoppingCarts.findById(shoppingCartId);
    }

    @Override
    public ShoppingCartOutput findByCustomerId(UUID customerId) {
        return forObtainingShoppingCarts.findByCustomerId(customerId);
    }
}