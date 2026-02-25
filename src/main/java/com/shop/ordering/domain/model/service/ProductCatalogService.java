package com.shop.ordering.domain.model.service;

import com.shop.ordering.domain.model.valueobject.Product;
import com.shop.ordering.domain.model.valueobject.id.ProductId;

import java.util.Optional;

public interface ProductCatalogService {
    Optional<Product> ofId(ProductId productId);
}
