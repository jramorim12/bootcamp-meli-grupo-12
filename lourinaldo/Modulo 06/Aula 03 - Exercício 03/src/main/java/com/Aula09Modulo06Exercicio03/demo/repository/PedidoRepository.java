package com.Aula09Modulo06Exercicio03.demo.repository;

import com.Aula09Modulo06Exercicio03.demo.models.Pedido;
import com.Aula09Modulo06Exercicio03.demo.models.Prato;

import java.util.ArrayList;
import java.util.List;


public interface PedidoRepository {
   public void adicionarPedido(Pedido pedido);
   public void adicionarPrato(int id,Prato prato);
   public void removerPedido(int id);
   public Pedido retornarPedido(int id);
   public List<Pedido> retornarPedido();
}

