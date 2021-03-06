package com.arutt.invoices;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.arutt.banking.Payment;
import com.arutt.banking.PaymentCreator;
import com.arutt.banking.PaymentException;

@Component
public class LocalPaymentCreator implements PaymentCreator {

    // hard coded account value for demo purposes
    private static final String CURRENT_LOCAL_ACC = "current-local-acc";

    @Override
    @Transformer
    public Payment createPayment(Invoice invoice) throws PaymentException {
        if (null == invoice.getAccount()) {
            throw new PaymentException("Account can not be empty when creating local payment!");
        }

        return new Payment(CURRENT_LOCAL_ACC, invoice.getAccount(), invoice.getDollars());
    }

}
