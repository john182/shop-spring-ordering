package com.shop.ordering.domain.model;

public interface AggregateRoot<ID> extends DomainEventSource {
    ID id();
}
