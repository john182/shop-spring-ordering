package com.shop.ordering.core.application.order;


import com.shop.ordering.core.ports.in.order.ForQueryingOrders;
import com.shop.ordering.core.ports.in.order.OrderFilter;
import com.shop.ordering.core.ports.out.order.ForObtainingOrders;
import com.shop.ordering.core.ports.out.order.OrderDetailOutput;
import com.shop.ordering.core.ports.out.order.OrderSummaryOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderQueryService implements ForQueryingOrders {

    private final ForObtainingOrders forObtainingOrders;

    public OrderDetailOutput findById(String id) {
        return forObtainingOrders.findById(id);
    }

    public Page<OrderSummaryOutput> filter(OrderFilter filter) {
        return forObtainingOrders.filter(filter);
    }
}
