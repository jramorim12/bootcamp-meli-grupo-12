package com.Aula09Modulo06Exercicio03.demo.repository;

import com.Aula09Modulo06Exercicio03.demo.models.Pedido;
import com.Aula09Modulo06Exercicio03.demo.models.Prato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonagensRepositoryImpl implements PedidoRepository {

    private List<Pedido> loadDataBase() {
        File file = null;
        List<Pedido> lista = null;

        try{
            file = ResourceUtils.getFile("classpath:pedido.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(file.length() > 0) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Pedido>> typeReference = new TypeReference<>(){};

        try{
            lista = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
            }

        return lista;
    }

    private void writePedido(Pedido pedido){
        try {
            List<Pedido> listaPedidos = loadDataBase();
            if(listaPedidos == null){
                listaPedidos = new ArrayList<>();
            }
            listaPedidos.add(pedido);
            File file = null;
            file = ResourceUtils.getFile("classpath:pedido.json");
            TypeReference<List<Pedido>> typeReference = new TypeReference<>(){};
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, listaPedidos);
            System.out.println(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addPrato(int id, Prato prato){
        try {
            List<Pedido> listaPedidos = loadDataBase();
            Pedido pedido = listaPedidos.stream().filter(p -> p.getId() == id).findFirst().get();
            pedido.getPratos().add(prato);
            File file = null;
            file = ResourceUtils.getFile("classpath:pedido.json");
            TypeReference<List<Pedido>> typeReference = new TypeReference<>(){};
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, listaPedidos);
            System.out.println(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePedido(int id){
        try {
            List<Pedido> listaPedidos = loadDataBase();
            listaPedidos = listaPedidos.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
            File file = null;
            file = ResourceUtils.getFile("classpath:pedido.json");
            TypeReference<List<Pedido>> typeReference = new TypeReference<>(){};
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, listaPedidos);
            System.out.println(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pedido getPedido(int id){
        List<Pedido> lista = loadDataBase();
        Pedido pedido = lista.stream().filter(p -> p.getId() == id).findFirst().get();
        return pedido;
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        writePedido(pedido);
    }

    @Override
    public void adicionarPrato(int id, Prato prato) {
        addPrato(id, prato);
    }

    @Override
    public void removerPedido(int id) {
        deletePedido(id);
    }

    @Override
    public Pedido retornarPedido(int id) {
        return getPedido(id);
    }

    @Override
    public List<Pedido> retornarPedido(){
        return loadDataBase();
    }
}
