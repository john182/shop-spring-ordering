package com.shop.ordering.domain.model.order;

import com.shop.ordering.domain.model.DomainService;
import com.shop.ordering.domain.model.product.Product;
import com.shop.ordering.domain.model.commons.Quantity;
import com.shop.ordering.domain.model.customer.CustomerId;

@DomainService
public class BuyNowService {

	public Order buyNow(Product product,
						CustomerId customerId,
						Billing billing,
						Shipping shipping,
						Quantity quantity,
						PaymentMethod paymentMethod) {
		
		product.checkOutOfStock();

		Order order = Order.draft(customerId);
		order.changeBilling(billing);
		order.changeShipping(shipping);
		order.changePaymentMethod(paymentMethod);
		order.addItem(product, quantity);
		order.place();

		return order;
	}

}
