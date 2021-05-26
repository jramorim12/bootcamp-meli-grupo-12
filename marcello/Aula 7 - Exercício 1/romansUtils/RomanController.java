package com.br.marcello.romansNumbers.romansUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RomanController {

    @Autowired
    private RomansUtils romansUtils;

    @GetMapping("/integerToRoman")
    public String integerToRoman (@RequestParam(value = "number") String number) {
        Integer numberInteger = Integer.parseInt(number);
        String romanNumber = this.romansUtils.converter(numberInteger);
        return "Your Integer number: " + numberInteger +  "\n"
                        + " Your Roman Number: " + romanNumber;
    }

    // Health Check
    @GetMapping("/ping")
    public String healthCheck(){
        return "pong";
    }

}
