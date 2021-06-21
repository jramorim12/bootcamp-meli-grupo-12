package com.example.demo.controller;

import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

   private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        UserEntity newUser = userService.addUser(userEntity);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable long id) {
        UserEntity newUser = userService.getUser(id);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.CREATED);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable long id) {
        userService.updateUser(userEntity, id);
        return new ResponseEntity<>("Usuário atualizado com sucesso!", HttpStatus.CREATED);
    }
}
