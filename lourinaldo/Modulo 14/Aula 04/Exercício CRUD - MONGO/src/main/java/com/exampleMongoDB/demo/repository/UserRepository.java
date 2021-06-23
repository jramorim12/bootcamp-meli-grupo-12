package com.exampleMongoDB.demo.repository;

import com.exampleMongoDB.demo.dtos.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDTO, String> {
    UserDTO deleteByLogin(String login);
    UserDTO findByLogin(String login);
}
