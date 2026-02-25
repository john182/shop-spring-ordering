package com.shop.ordering.domain.model.repository;

import com.shop.ordering.domain.model.entity.AggregateRoot;

import java.util.Optional;

public interface Repository<T extends AggregateRoot<ID>, ID> {
    Optional<T> ofId(ID id);
    boolean exists(ID id);
    void add(T aggregateRoot);
    long count();
}
