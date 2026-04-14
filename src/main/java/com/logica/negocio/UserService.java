package com.logica.negocio;

public class UserService {
	
	public void register(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email requerido");
        }
    }

}
