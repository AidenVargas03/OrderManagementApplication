package com.gcu.ordermanagement.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.entity.UserEntity;
import com.gcu.ordermanagement.data.repository.UserRepository;


@Service
public class UsersDataService<T> implements UsersDataAccessInterface<T>, DataAccessInterface<T> {

	@Autowired
	UserRepository usersRepository;
	
	public UsersDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return usersRepository.findByUsername(username);
	}

}
