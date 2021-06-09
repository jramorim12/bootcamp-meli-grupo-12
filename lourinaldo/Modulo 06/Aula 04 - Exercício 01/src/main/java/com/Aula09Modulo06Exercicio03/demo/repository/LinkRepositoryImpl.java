package com.Aula09Modulo06Exercicio03.demo.repository;

import com.Aula09Modulo06Exercicio03.demo.dtos.LinkDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private List<LinkDTO> loadDataBase() {
        File file = null;
        List<LinkDTO> lista = null;

        try{
            file = ResourceUtils.getFile("classpath:link.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(file.length() > 0) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<LinkDTO>> typeReference = new TypeReference<>(){};

        try{
            lista = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
            }

        return lista;
    }

    private void updateCounter(LinkDTO link){
        link.setCounter(link.getCounter()+1);
        deleteLink(link.getId());
        addLink(link);
    }

    private LinkDTO getLink(int id){
        List<LinkDTO> lista = loadDataBase();
        LinkDTO link = lista.stream().filter(p -> p.getId() == id).findFirst().get();
        updateCounter(link);
        return link;
    }

    @Override
    public LinkDTO retornarLink(int id) {
        return getLink(id);
    }

    @Override
    public void addLink(LinkDTO link) {
        try {
            List<LinkDTO> listaLinks = loadDataBase();
            listaLinks.add(link);
            File file = null;
            file = ResourceUtils.getFile("classpath:link.json");
            TypeReference<List<LinkDTO>> typeReference = new TypeReference<>(){};
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, listaLinks);
            System.out.println(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLink(int id) {
        try {
            List<LinkDTO> listaLinks = loadDataBase();
            listaLinks = listaLinks.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
            File file = null;
            file = ResourceUtils.getFile("classpath:link.json");
            TypeReference<List<LinkDTO>> typeReference = new TypeReference<>(){};
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, listaLinks);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
