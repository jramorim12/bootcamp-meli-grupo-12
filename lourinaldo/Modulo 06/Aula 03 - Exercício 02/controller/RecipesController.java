package com.Aula09Modulo06Exercicio02.demo.controller;

import com.Aula09Modulo06Exercicio02.demo.dtos.ResponseDTO;
import com.Aula09Modulo06Exercicio02.demo.repository.PersonagensRepository;
import com.Aula09Modulo06Exercicio02.demo.dtos.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RecipesController {

    @Autowired
    private PersonagensRepository repository;

    @PostMapping ("/retornarPrato")
    public ResponseDTO retornarInformacoes(@RequestBody RequestDTO substring){

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPersonagens(repository.personagens(substring));
        return responseDTO;
    }

}
