package com.gcu.ordermanagement.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gcu.ordermanagement.data.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
