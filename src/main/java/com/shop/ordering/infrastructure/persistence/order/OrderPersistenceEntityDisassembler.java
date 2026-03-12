package com.shop.ordering.infrastructure.persistence.order;

import com.shop.ordering.domain.model.order.Order;
import com.shop.ordering.domain.model.order.OrderStatus;
import com.shop.ordering.domain.model.order.PaymentMethod;
import com.shop.ordering.domain.model.commons.Money;
import com.shop.ordering.domain.model.commons.Quantity;

import com.shop.ordering.domain.model.customer.CustomerId;
import com.shop.ordering.domain.model.order.OrderId;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class OrderPersistenceEntityDisassembler {

    public Order toDomainEntity(OrderPersistenceEntity persistenceEntity) {
        return Order.existing()
                .id(new OrderId(persistenceEntity.getId()))
                .customerId(new CustomerId(persistenceEntity.getCustomerId()))
                .totalAmount(new Money(persistenceEntity.getTotalAmount()))
                .totalItems(new Quantity(persistenceEntity.getTotalItems()))
                .status(OrderStatus.valueOf(persistenceEntity.getStatus()))
                .paymentMethod(PaymentMethod.valueOf(persistenceEntity.getPaymentMethod()))
                .placedAt(persistenceEntity.getPlacedAt())
                .paidAt(persistenceEntity.getPaidAt())
                .canceledAt(persistenceEntity.getCanceledAt())
                .readyAt(persistenceEntity.getReadyAt())
                .items(new HashSet<>())
                .build();
    }

}
