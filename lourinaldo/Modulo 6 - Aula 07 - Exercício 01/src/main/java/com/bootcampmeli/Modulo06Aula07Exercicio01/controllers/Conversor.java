package com.bootcampmeli.Modulo06Aula07Exercicio01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Conversor {

    public static String conversor(Integer numero){
        int[] vaNum = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] vaRom = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        String result = "";
        while (numero > 0) {
            if (numero >= vaNum[i]) {
                result += vaRom[i]+"";
                numero -= vaNum[i];
            } else {
                i++;
            }
        }
        return result;
    }

    @GetMapping("/{n}")
    public String  convertendo(@PathVariable Integer n){
        return conversor(n);
    }
}
