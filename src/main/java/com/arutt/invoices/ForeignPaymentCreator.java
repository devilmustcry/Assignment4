package com.arutt.invoices;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.arutt.banking.Payment;
import com.arutt.banking.PaymentCreator;
import com.arutt.banking.PaymentException;

@Component
public class ForeignPaymentCreator implements PaymentCreator {

    // hard coded account value for demo purposes
    private static final String CURRENT_IBAN_ACC = "current-iban-acc";

    @Override
    @Transformer
    public Payment createPayment(Invoice invoice) throws PaymentException {
        if (null == invoice.getIban()) {
            throw new PaymentException("IBAN mustn't be null when creating foreign payment!");
        }

        return new Payment(CURRENT_IBAN_ACC, invoice.getIban(), invoice.getDollars());
    }

}
