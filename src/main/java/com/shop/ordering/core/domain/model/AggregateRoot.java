package com.shop.ordering.core.domain.model;

public interface AggregateRoot<ID> extends DomainEventSource {
    ID id();
}
