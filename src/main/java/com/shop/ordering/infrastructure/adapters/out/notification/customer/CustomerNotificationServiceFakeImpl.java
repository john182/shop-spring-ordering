package com.shop.ordering.infrastructure.adapters.out.notification.customer;

import com.shop.ordering.core.ports.out.customer.ForNotifyingCustomers;
import com.shop.ordering.core.domain.model.customer.Customers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerNotificationServiceFakeImpl implements ForNotifyingCustomers {

    private final Customers customers;

    @Override
    public void notifyNewRegistration(NotifyNewRegistrationInput input) {
        log.info("Welcome {}", input.firstName());
        log.info("User your email to access your account {}", input.email());
    }
}
