package com.shop.ordering.domain.model.valueobject;

import com.shop.ordering.domain.model.commons.Address;
import com.shop.ordering.domain.model.commons.Document;
import com.shop.ordering.domain.model.commons.FullName;
import com.shop.ordering.domain.model.commons.Phone;
import lombok.Builder;

import java.util.Objects;

@Builder
public record BillingInfo(FullName fullName, Document document, Phone phone, Address address) {
	public BillingInfo {
		Objects.requireNonNull(fullName);
		Objects.requireNonNull(document);
		Objects.requireNonNull(phone);
		Objects.requireNonNull(address);
	}
}
