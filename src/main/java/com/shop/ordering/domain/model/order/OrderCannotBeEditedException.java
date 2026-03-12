package com.shop.ordering.domain.model.order;

import com.shop.ordering.domain.model.DomainException;
import com.shop.ordering.domain.model.ErrorMessages;

public class OrderCannotBeEditedException extends DomainException {

	public OrderCannotBeEditedException(OrderId id, OrderStatus status) {
		super(String.format(ErrorMessages.ERROR_ORDER_CANNOT_BE_EDITED, id, status));
	}
}
