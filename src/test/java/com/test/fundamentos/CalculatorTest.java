package com.test.fundamentos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fundamentos.Calculator;

public class CalculatorTest 
{
	
	private Calculator calculator;
	
	@BeforeEach
	void setUp()
	{
//		System.out.println("Antes del test");
		calculator = new Calculator();
	}
	
	@Test
	void shouldAddNumbers()
	{
		int result = calculator.add(2, 3);
//		System.out.println("Despues del test = " + result);
		assertEquals(5, result);
		
	}
}
