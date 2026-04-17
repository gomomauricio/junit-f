package com.fin;

import com.eje1.PaymentGateway;

public class OrderService {
	

    private PaymentGateway gateway;

    public OrderService(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public String placeOrder(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        boolean paid = gateway.pay(amount);

        return paid ? "SUCCESS" : "FAIL";
    }

}
