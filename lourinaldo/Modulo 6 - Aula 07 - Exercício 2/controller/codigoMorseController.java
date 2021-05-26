package com.bootcampmeli.Modulo06Aula07Exercicio02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class codigoMorseController {

    public static Map<String, String> mapeamento = new HashMap<>();
    static {
        mapeamento.put(".-","A");
        mapeamento.put("-...","B");
        mapeamento.put("-.-.","C");
        mapeamento.put("-..","D");
        mapeamento.put(".","E");
        mapeamento.put("..-.","F");
        mapeamento.put("--.","G");
        mapeamento.put("....","H");
        mapeamento.put("..","I");
        mapeamento.put(".---","J");
        mapeamento.put("-.-","K");
        mapeamento.put(".-..","L");
        mapeamento.put("--","M");
        mapeamento.put("-.","N");
        mapeamento.put("---","O");
        mapeamento.put(".--.","P");
        mapeamento.put("--.-","Q");
        mapeamento.put(".-.","R");
        mapeamento.put("...","S");
        mapeamento.put("-","T");
        mapeamento.put("..-","U");
        mapeamento.put("...-","V");
        mapeamento.put(".--","W");
        mapeamento.put("-..-","X");
        mapeamento.put("-.--","Y");
        mapeamento.put("--..","Z");
    }

    @GetMapping("/{codigo}")
    public String tradutorMorse(@PathVariable String codigo){

        String traducao = "";
        String[] palavras = codigo.split("  ");

        for(String p : palavras){
            String[] aux = p.split(" ");
            for(String paux : aux){
                traducao += mapeamento.get(paux);
            }
            traducao += " ";
        }
        System.out.println(mapeamento.get("."));
        return traducao;
    }
}
