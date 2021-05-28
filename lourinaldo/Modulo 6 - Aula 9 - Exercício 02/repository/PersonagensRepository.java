package com.Aula09Modulo06Exercicio02.demo.repository;

import com.Aula09Modulo06Exercicio02.demo.dtos.PersonagemDTO;
import com.Aula09Modulo06Exercicio02.demo.dtos.RequestDTO;

import java.util.ArrayList;
import java.util.List;

public interface PersonagensRepository {
   public ArrayList<String> personagens(RequestDTO requestDTO);
}

