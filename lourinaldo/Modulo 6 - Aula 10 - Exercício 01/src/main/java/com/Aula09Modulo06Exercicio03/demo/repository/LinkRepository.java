package com.Aula09Modulo06Exercicio03.demo.repository;

import com.Aula09Modulo06Exercicio03.demo.dtos.LinkDTO;



public interface LinkRepository {
   public LinkDTO retornarLink(int id);
   public void addLink(LinkDTO link);
   public void deleteLink(int id);
}

