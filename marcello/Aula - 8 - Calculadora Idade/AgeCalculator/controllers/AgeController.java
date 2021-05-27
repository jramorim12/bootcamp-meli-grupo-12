package br.com.marcello.AgeCalculator.controllers;


import br.com.marcello.AgeCalculator.utils.AgeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    @Autowired
    private AgeUtils ageUtils;

    @GetMapping("/age")
    public String getYourAge(@RequestParam(value = "date") String date) {
        return this.ageUtils.calculateAge(date);
    }

}
