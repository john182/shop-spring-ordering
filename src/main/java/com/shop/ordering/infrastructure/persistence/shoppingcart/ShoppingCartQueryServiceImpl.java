package com.shop.ordering.infrastructure.persistence.shoppingcart;

import com.shop.ordering.core.ports.in.shoppingcart.ShoppingCartOutput;
import com.shop.ordering.core.application.utility.Mapper;
import com.shop.ordering.core.domain.model.shoppingcart.ShoppingCartNotFoundException;
import com.shop.ordering.core.ports.out.shoppingcart.ForObtainingShoppingCarts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ShoppingCartQueryServiceImpl implements ForObtainingShoppingCarts {

    private final ShoppingCartPersistenceEntityRepository persistenceRepository;
    private final Mapper mapper;

    @Override
    public ShoppingCartOutput findById(UUID shoppingCartId) {
        return persistenceRepository.findById(shoppingCartId)
                .map(s -> mapper.convert(s, ShoppingCartOutput.class))
                .orElseThrow(()->new ShoppingCartNotFoundException(shoppingCartId));
    }

    @Override
    public ShoppingCartOutput findByCustomerId(UUID customerId) {
        return persistenceRepository.findByCustomer_Id(customerId)
                .map(s -> mapper.convert(s, ShoppingCartOutput.class))
                .orElseThrow(()->ShoppingCartNotFoundException.ofCustomer(customerId));
    }
}
