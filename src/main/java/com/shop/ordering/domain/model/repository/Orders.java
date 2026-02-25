package com.shop.ordering.domain.model.repository;

import com.shop.ordering.domain.model.entity.Order;
import com.shop.ordering.domain.model.valueobject.Money;
import com.shop.ordering.domain.model.valueobject.id.CustomerId;
import com.shop.ordering.domain.model.valueobject.id.OrderId;

import java.time.Year;
import java.util.List;

public interface Orders extends Repository<Order, OrderId> {
    List<Order> placedByCustomerInYear(CustomerId customerId, Year year);
    long salesQuantityByCustomerInYear(CustomerId customerId, Year year);
    Money totalSoldForCustomer(CustomerId customerId);
}
