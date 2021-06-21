package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserService {

    public UserEntity addUser(UserEntity userEntity);
    public UserEntity getUser(long id);
    public void deleteUser(long id);
    public void updateUser(UserEntity user, long id);
}
