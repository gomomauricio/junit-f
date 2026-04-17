package com.eje1;

public class PaymentService {
	 private PaymentGateway gateway;

	    public PaymentService(PaymentGateway gateway) {
	        this.gateway = gateway;
	    }

	    public boolean process(double amount) {
	        if (amount <= 0) return false;
	        return gateway.pay(amount);
	    }
}
