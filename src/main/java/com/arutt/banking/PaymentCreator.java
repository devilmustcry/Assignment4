package com.arutt.banking;

import com.arutt.invoices.Invoice;

/**
 * Creates payment for bank from the invoice.
 * Real world implementation might do some I/O expensive stuff.
 */
public interface PaymentCreator {

    Payment createPayment(Invoice invoice) throws PaymentException;

}
