package com.Aula08Modulo06Exercicio01.demo.controller;

import com.Aula08Modulo06Exercicio01.demo.dtos.MensagemDTO;
import com.Aula08Modulo06Exercicio01.demo.models.Aluno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class mensagemController {
    @PostMapping ("/")
    public MensagemDTO retornarMensagem(@RequestBody Aluno aluno){
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setNome(aluno.getNome());
        mensagemDTO.setMedia(aluno.media());
        mensagemDTO.setMsg(aluno.mensagem());

        return mensagemDTO;
    }

}

/*
    Exemplo de Resquest Body

    {
    "nome" : "Lourinaldo",
    "disciplinas":[
        {"nome": "Química", "nota":9.2},
        {"nome": "Matemática", "nota":9},
        {"nome": "Português", "nota":9.1},
        {"nome": "Física", "nota":9}
    ]
}
 */
