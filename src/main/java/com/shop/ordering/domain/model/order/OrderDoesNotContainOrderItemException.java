package com.shop.ordering.domain.model.order;

import com.shop.ordering.domain.model.DomainException;
import com.shop.ordering.domain.model.ErrorMessages;

public class OrderDoesNotContainOrderItemException extends DomainException {
    public OrderDoesNotContainOrderItemException(OrderId id, OrderItemId orderItemId) {
        super(String.format(ErrorMessages.ERROR_ORDER_DOES_NOT_CONTAIN_ITEM, id, orderItemId));
    }
}
