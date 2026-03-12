package com.shop.ordering.domain.model.customer;

import com.shop.ordering.domain.model.commons.Email;
import com.shop.ordering.domain.model.Repository;

import java.util.Optional;

public interface Customers extends Repository<Customer, CustomerId> {
    Optional<Customer> ofEmail(Email email);
    boolean isEmailUnique(Email email, CustomerId exceptCustomerId);
}
