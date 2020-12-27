package com.ebdz.testing.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
