package com.Aula08Modulo06Exercicio01.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class idadeController {
    @GetMapping("/")
    public int retornaIdade(@RequestParam(value = "data") String data){
        Date birthDate = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar birthCalendar = new GregorianCalendar();
        Calendar nowCalendar = new GregorianCalendar();

        try{
            birthDate = df.parse(data);
            birthCalendar.setTime(birthDate);
            int idade = nowCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
            if(nowCalendar.get(Calendar.MONTH) < birthCalendar.get(Calendar.MONTH)){
                return --idade;
            }else if(nowCalendar.get(Calendar.MONTH) == birthCalendar.get(Calendar.MONTH)){
                if(nowCalendar.get(Calendar.DAY_OF_MONTH) < birthCalendar.get(Calendar.DAY_OF_MONTH)){
                    return --idade;
                }
            }
            return idade;
            } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        return 0;
    }

}
