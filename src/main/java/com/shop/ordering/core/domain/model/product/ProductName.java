package com.shop.ordering.core.domain.model.product;

import com.shop.ordering.core.domain.model.FieldValidations;

public record ProductName(String value) {

	public ProductName {
		FieldValidations.requiresNonBlank(value);
	}

	@Override
	public String toString() {
		return value;
	}

}
