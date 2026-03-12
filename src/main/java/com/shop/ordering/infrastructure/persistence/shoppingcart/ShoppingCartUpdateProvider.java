package com.shop.ordering.infrastructure.persistence.shoppingcart;

import com.shop.ordering.domain.model.commons.Money;
import com.shop.ordering.domain.model.product.ProductId;
import com.shop.ordering.domain.model.shoppingcart.ShoppingCartProductAdjustmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ShoppingCartUpdateProvider implements ShoppingCartProductAdjustmentService {

    private final ShoppingCartPersistenceEntityRepository shoppingCartPersistenceEntityRepository;

    @Override
    @Transactional
    public void adjustPrice(ProductId productId, Money updatedPrice) {
        shoppingCartPersistenceEntityRepository.updateItemPrice(productId.value(), updatedPrice.value());
        shoppingCartPersistenceEntityRepository.recalculateTotalsForCartsWithProduct(productId.value());
    }

    @Override
    @Transactional
    public void changeAvailability(ProductId productId, boolean available) {
        shoppingCartPersistenceEntityRepository.updateItemAvailability(productId.value(), available);
    }
}
