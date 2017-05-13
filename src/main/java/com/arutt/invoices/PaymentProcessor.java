package com.arutt.invoices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.arutt.banking.BankingService;
import com.arutt.banking.Payment;
import com.arutt.banking.PaymentException;

/**
 * Endpoint that picks Payments from the system and dispatches them to the
 * service provided by bank.
 */
@Component
public class PaymentProcessor {

    @Autowired
    BankingService bankingService;

    @ServiceActivator
    public void processPayment(Payment payment) throws PaymentException {
        bankingService.pay(payment);
    }

}
