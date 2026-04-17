package com.test.fin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eje1.PaymentGateway;
import com.fin.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	 
	@Mock
	PaymentGateway gateway;
	
	@InjectMocks
	OrderService service;
	 
	//* Caso exitoso 
	@Test
    public void shouldReturnSuccess_whenPaymentIsApproved() {
		when( gateway.pay(100) ).thenReturn(true);
		
		String result = service.placeOrder(100.0);
		verify(gateway).pay(100); //validar que se llamó el gateway.
//System.out.println("A result=" + result);
	    assertEquals("SUCCESS", result);
 
    }
	
	
	//	* Caso fallo
	@Test
    public void shouldReturnFail_whenPaymentIsRejected() {
		when( gateway.pay(10) ).thenReturn(false);
		
		String result = service.placeOrder(10.0);
		verify(gateway).pay(10); //validar que se llamó el gateway.
//		System.out.println("B result=" + result); //no se debe imprimir nada debe ser un test limpio
	    assertEquals("FAIL", result);
 
    }
    
    
//	* Excepción
    @Test
	public void shouldThrowException_whenAmountIsZeroOrNegative()
	{
		assertThrows( IllegalArgumentException.class , () -> service.placeOrder(0.0));
		
		 verify(gateway, never()).pay(anyDouble()); //never que no es llamado el componente
	}
    
    
    

}
