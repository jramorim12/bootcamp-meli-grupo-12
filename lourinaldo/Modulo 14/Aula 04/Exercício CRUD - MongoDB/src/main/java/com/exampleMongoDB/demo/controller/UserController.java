package com.exampleMongoDB.demo.controller;

import com.exampleMongoDB.demo.dtos.UserDTO;
import com.exampleMongoDB.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping
    public ArrayList<UserDTO> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{login}")
    public UserDTO findUserByLogin(@PathVariable String login){
        return userService.findUserByLogin(login);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("{login}")
    public String deleteUser(@PathVariable String login){
        userService.deleteUser(login);
        return "Usuário removido com sucesso";
    }
}
