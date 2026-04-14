package com.test.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.UserRepository;
import com.mockito.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest 
{
	@Mock
	UserRepository repo;
	
	@InjectMocks
	UserService service;
	
	@Test
	public void shouldReturnUserName()
	{
		   System.out.println("TEST RUNNING");
		when(repo.findNameById(1)).thenReturn("Mauricio");
		
		String result = service.getUserName(1);
		
		assertEquals("Mauricio", result);
		
	}
	

}
