package com.example.demo.service;

import com.example.demo.dtos.UserNewPasswordDTO;
import com.example.demo.models.UserModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> findUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel findUserById(long id){return userRepository.findById(id);}

    public ArrayList<UserModel> findUsersByName(String name){
        return (ArrayList<UserModel>) userRepository.findUserByName(name);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public void updateUser(UserNewPasswordDTO userNewPasswordDTO){
        userRepository.updateUser(userNewPasswordDTO.getPassword(), userNewPasswordDTO.getId());
    }

    public void deleteUser(long id){
        userRepository.deleteUser(id);
    }



}
