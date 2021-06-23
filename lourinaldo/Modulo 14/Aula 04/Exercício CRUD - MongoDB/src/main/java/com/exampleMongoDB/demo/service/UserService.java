package com.exampleMongoDB.demo.service;

import com.exampleMongoDB.demo.dtos.UserDTO;
import com.exampleMongoDB.demo.repository.AddressRepository;
import com.exampleMongoDB.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    final UserRepository userRepository;
    final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public UserDTO createUser(UserDTO userDTO){
        addressRepository.saveAll(userDTO.getAdresses());
        return userRepository.save(userDTO);
    }

    public UserDTO findUserByLogin(String s){
        return userRepository.findByLogin(s);
    }

    public ArrayList findAllUsers(){
        return (ArrayList) userRepository.findAll();
    }

    public UserDTO updateUser(UserDTO user){
        UserDTO userOld = userRepository.findByLogin(user.getLogin());
        userOld.setPassword(user.getPassword());
        return userRepository.save(userOld);
    }

    public void deleteUser(String s){
        userRepository.deleteByLogin(s);
    }
}
