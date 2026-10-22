package com.shop.ordering.core.domain.model.order;

import com.shop.ordering.core.domain.model.commons.Document;
import com.shop.ordering.core.domain.model.commons.FullName;
import com.shop.ordering.core.domain.model.commons.Phone;
import lombok.Builder;

import java.util.Objects;

@Builder
public record Recipient(FullName fullName, Document document, Phone phone) {
    public Recipient {
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(document);
        Objects.requireNonNull(phone);
    }
}
