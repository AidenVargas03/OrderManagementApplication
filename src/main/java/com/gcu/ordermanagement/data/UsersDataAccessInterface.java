package com.gcu.ordermanagement.data;

import com.gcu.ordermanagement.data.entity.UserEntity;

public interface UsersDataAccessInterface <T>{

	public UserEntity findByUsername(String username);
}
