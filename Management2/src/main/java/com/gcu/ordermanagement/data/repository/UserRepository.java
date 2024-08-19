package com.gcu.ordermanagement.data.repository;

import com.gcu.ordermanagement.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
