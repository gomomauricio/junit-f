package com.test.verificacion;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.UserRepository;
import com.mockito.UserService;

@ExtendWith(MockitoExtension.class)
public class VerificacionTest  {

	@Mock
	UserRepository repo;
	
	@InjectMocks
	UserService service;
	 
 
    @Test
    public void shouldCallRepository() {
        service.getUserName(1);

        verify(repo).findNameById(1);
    }
	
	
}
