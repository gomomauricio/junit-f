package com.test.eje1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eje1.PaymentGateway;
import com.eje1.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
	
	
	@Mock
	PaymentGateway gateway;
	
	@InjectMocks
	PaymentService service;
	
	
	@Test
	void shouldProcessPayment() {
	    when(gateway.pay(100)).thenReturn(true);

	    boolean result = service.process(100);
	    System.out.println("result=" + result);

	    assertTrue(result);
	    verify(gateway).pay(100);
	}

}
