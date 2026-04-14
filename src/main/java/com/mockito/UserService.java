package com.mockito;

public class UserService 
{
	 private UserRepository repo;

	    public UserService(UserRepository repo) {
	        this.repo = repo;
	    }

	    public String getUserName(int id) {
	        return repo.findNameById(id);
	    }
}
