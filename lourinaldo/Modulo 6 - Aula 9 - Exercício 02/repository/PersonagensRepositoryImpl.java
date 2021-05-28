package com.Aula09Modulo06Exercicio02.demo.repository;

import com.Aula09Modulo06Exercicio02.demo.dtos.PersonagemDTO;
import com.Aula09Modulo06Exercicio02.demo.dtos.RequestDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonagensRepositoryImpl implements PersonagensRepository {

    private List<PersonagemDTO> loadDataBase() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonagemDTO>> typeReference = new TypeReference<>(){};
        List<PersonagemDTO> lista = null;

        try{
            lista = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<String> personagens(RequestDTO subtring) {

        List<PersonagemDTO> personagens = null;
        ArrayList<String> listaRetorno = new ArrayList<>();
        List<PersonagemDTO> listPersonagem = this.loadDataBase();

        personagens = listPersonagem.stream().filter(p -> p.getName().contains(subtring.getNome())).collect(Collectors.toList());
        for(PersonagemDTO p : personagens){
            System.out.println(p.getName());
            listaRetorno.add(p.getName());
        }

        return listaRetorno;

    }
}
