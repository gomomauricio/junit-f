package com.test.logica.negocio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.logica.negocio.UserService;

public class UserServiceTest {
	
	private UserService userService;
	
	@BeforeEach
	public void setUp()
	{
		userService = new UserService();
	}
	
	
	@Test
	public void shouldThrowException_whenEmailIsNull()
	{
		assertThrows( IllegalArgumentException.class , () -> userService.register(null));
	}

}
