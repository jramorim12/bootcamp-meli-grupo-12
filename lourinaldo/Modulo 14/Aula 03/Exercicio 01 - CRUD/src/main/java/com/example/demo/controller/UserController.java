package com.example.demo.controller;

import com.example.demo.dtos.UserNewPasswordDTO;
import com.example.demo.models.UserModel;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ArrayList<UserModel> listUser(){
        return userService.findUsers();
    }

    @GetMapping("/{id}")
    public UserModel findUserById(@PathVariable long id){
        return userService.findUserById(id);
    }

    @GetMapping("/list/{name}")
    public ArrayList<UserModel> findUserByName(@PathVariable String name){
        return userService.findUsersByName(name);
    }


    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel){
        return this.userService.saveUser(userModel);

    }

    @PutMapping
    public ResponseEntity updateUserPassword(@RequestBody UserNewPasswordDTO userNewPasswordDTO){
        this.userService.updateUser(userNewPasswordDTO);
        return new ResponseEntity<String>("Atualização realizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable long id){
        this.userService.deleteUser(id);
        return new ResponseEntity<String>("ID deletado com sucesso!", HttpStatus.OK);
    }


}
