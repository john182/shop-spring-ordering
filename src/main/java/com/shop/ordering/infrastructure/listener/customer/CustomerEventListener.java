package com.shop.ordering.infrastructure.listener.customer;

import com.shop.ordering.application.customer.loyaltypoints.CustomerLoyaltyPointsApplicationService;
import com.shop.ordering.application.customer.notification.CustomerNotificationApplicationService;
import com.shop.ordering.domain.model.customer.CustomerArchivedEvent;
import com.shop.ordering.domain.model.customer.CustomerRegisteredEvent;
import com.shop.ordering.domain.model.order.OrderReadyEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerEventListener {

    private final CustomerNotificationApplicationService customerNotificationService;
    private final CustomerLoyaltyPointsApplicationService customerLoyaltyPointsApplicationService;

    @EventListener
    public void listen(CustomerRegisteredEvent event) {
        log.info("CustomerRegisteredEvent listen 1");
        CustomerNotificationApplicationService.NotifyNewRegistrationInput input = new CustomerNotificationApplicationService.NotifyNewRegistrationInput(
                event.customerId().value(),
                event.fullName().firstName(),
                event.email().value()
        );
        customerNotificationService.notifyNewRegistration(input);
    }

    @EventListener
    public void listenSecondary(CustomerRegisteredEvent event) {
        log.info("CustomerRegisteredEvent listen 2");
    }

    @EventListener
    public void listen(OrderReadyEvent event) {
        customerLoyaltyPointsApplicationService.addLoyaltyPoints(event.customerId().value(),
                event.orderId().toString());
    }

}
