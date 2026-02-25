package com.shop.ordering.domain.model.exception;

import com.shop.ordering.domain.model.entity.OrderStatus;
import com.shop.ordering.domain.model.valueobject.id.OrderId;

import static com.shop.ordering.domain.model.exception.ErrorMessages.ERROR_ORDER_STATUS_CANNOT_BE_CHANGED;

public class OrderStatusCannotBeChangedException extends DomainException {

    public OrderStatusCannotBeChangedException(OrderId id, OrderStatus status, OrderStatus newStatus) {
        super(String.format(ERROR_ORDER_STATUS_CANNOT_BE_CHANGED, id, status, newStatus));
    }
}
