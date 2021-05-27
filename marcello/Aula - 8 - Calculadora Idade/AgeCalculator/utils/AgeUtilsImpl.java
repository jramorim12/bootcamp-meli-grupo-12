package br.com.marcello.AgeCalculator.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class AgeUtilsImpl implements AgeUtils{

    @Override
    public String calculateAge(String dateString) {

        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("Impossible to parse Date", e);
        }

        Long difference = System.currentTimeMillis() - date.getTime();
        Long age = difference /(1000L * 60 * 60 * 24 * 365);

        return "Your age is: " + age;
    }
}
