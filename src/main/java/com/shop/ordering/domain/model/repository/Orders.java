package com.shop.ordering.domain.model.repository;

import com.shop.ordering.domain.model.entity.Order;
import com.shop.ordering.domain.model.valueobject.id.OrderId;

public interface Orders extends Repository<Order, OrderId> {
}
