package com.Aula09Modulo06Exercicio03.demo.controller;

import com.Aula09Modulo06Exercicio03.demo.dtos.LinkDTO;
import com.Aula09Modulo06Exercicio03.demo.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;

@RestController
public class PedidoController {

    @Autowired
    private LinkRepository repository;

    @GetMapping ("/getURL/{id}")
    public String retornarURL(@PathVariable int id) {
        LinkDTO link = repository.retornarLink(id);
        return "Link retornado: " + link.getLink() + " Número de acessos: " + link.getCounter();
    }

    @PostMapping ("/addURL")
    public ResponseEntity addURL(@RequestBody LinkDTO link){
        repository.addLink(link);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping ("/deleteURL/{id}")
    public ResponseEntity deleteURL(@PathVariable int id){
        repository.deleteLink(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
