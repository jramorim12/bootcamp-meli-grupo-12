package com.Aula09Modulo06Exercicio03.demo.controller;

import com.Aula09Modulo06Exercicio03.demo.models.Pedido;
import com.Aula09Modulo06Exercicio03.demo.models.Prato;
import com.Aula09Modulo06Exercicio03.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @PostMapping ("/adicionarPedido")
    public ResponseEntity adicionarPedido(@RequestBody Pedido pedido){
        repository.adicionarPedido(pedido);
        return new ResponseEntity<>("Pedido inserido com sucesso", HttpStatus.OK);
    }

    @GetMapping ("retornarPedido/{id}")
    public Pedido retornarPedido(@PathVariable int id){
        return repository.retornarPedido(id);
    }

    @GetMapping ("retornarPedido")
    public List<Pedido> retornarPedidido(){
        return repository.retornarPedido();
    }

    @DeleteMapping ("removerPedido/{id}")
    public ResponseEntity<String> removerPedido(@PathVariable int id){
        repository.removerPedido(id);
        return new ResponseEntity<String>("Pedido removido com sucesso", HttpStatus.OK);
    }

    @PutMapping ("adicionarPrato/{id}")
    public ResponseEntity adicionarPrato(@PathVariable int id, @RequestBody Prato prato){
        repository.adicionarPrato(id, prato);
        return new ResponseEntity("Prato adicionar com sucesso", HttpStatus.OK);
    }


}
