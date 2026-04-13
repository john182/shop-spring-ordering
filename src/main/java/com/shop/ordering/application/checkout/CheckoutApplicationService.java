package com.shop.ordering.application.checkout;

import com.shop.ordering.domain.model.commons.ZipCode;
import com.shop.ordering.domain.model.customer.Customer;
import com.shop.ordering.domain.model.customer.CustomerNotFoundException;
import com.shop.ordering.domain.model.customer.Customers;
import com.shop.ordering.domain.model.order.CheckoutService;
import com.shop.ordering.domain.model.order.Order;
import com.shop.ordering.domain.model.order.Orders;
import com.shop.ordering.domain.model.order.PaymentMethod;
import com.shop.ordering.domain.model.order.shipping.OriginAddressService;
import com.shop.ordering.domain.model.order.shipping.ShippingCostService;
import com.shop.ordering.domain.model.product.Product;
import com.shop.ordering.domain.model.product.ProductCatalogService;
import com.shop.ordering.domain.model.product.ProductId;
import com.shop.ordering.domain.model.product.ProductNotFoundException;
import com.shop.ordering.domain.model.shoppingcart.ShoppingCart;
import com.shop.ordering.domain.model.shoppingcart.ShoppingCartId;
import com.shop.ordering.domain.model.shoppingcart.ShoppingCartNotFoundException;
import com.shop.ordering.domain.model.shoppingcart.ShoppingCarts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CheckoutApplicationService {

	private final Orders orders;
	private final ShoppingCarts shoppingCarts;
	private final Customers customers;

	private final CheckoutService checkoutService;

	private final BillingInputDisassembler billingInputDisassembler;
	private final ShippingInputDisassembler shippingInputDisassembler;

	private final ShippingCostService shippingCostService;
	private final OriginAddressService originAddressService;
	private final ProductCatalogService productCatalogService;

	@Transactional
	public String checkout(CheckoutInput input) {
		Objects.requireNonNull(input);
		PaymentMethod paymentMethod = PaymentMethod.valueOf(input.getPaymentMethod());

		ShoppingCartId shoppingCartId = new ShoppingCartId(input.getShoppingCartId());
		ShoppingCart shoppingCart = shoppingCarts.ofId(shoppingCartId)
				.orElseThrow(() -> new ShoppingCartNotFoundException());

		Customer customer = customers.ofId(shoppingCart.customerId()).orElseThrow(() -> new CustomerNotFoundException());

		var shippingCalculationResult = calculateShippingCost(input.getShipping());

		Order order = checkoutService.checkout(customer, shoppingCart,
				billingInputDisassembler.toDomainModel(input.getBilling()),
				shippingInputDisassembler.toDomainModel(input.getShipping(), shippingCalculationResult),
				paymentMethod);

		orders.add(order);
		shoppingCarts.add(shoppingCart);

		return order.id().toString();
	}

	private ShippingCostService.CalculationResult calculateShippingCost(ShippingInput shipping) {
		ZipCode origin = originAddressService.originAddress().zipCode();
		ZipCode destination = new ZipCode(shipping.getAddress().getZipCode());
		return shippingCostService.calculate(new ShippingCostService.CalculationRequest(origin, destination));
	}

	private Product findProduct(ProductId productId) {
		return productCatalogService.ofId(productId)
				.orElseThrow(ProductNotFoundException::new);
	}

}
