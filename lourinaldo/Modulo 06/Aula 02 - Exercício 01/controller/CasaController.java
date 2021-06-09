package com.Aula08Modulo06Exercicio01.demo.controller;

import com.Aula08Modulo06Exercicio01.demo.dtos.CaracteristicasDTO;
import com.Aula08Modulo06Exercicio01.demo.models.Casa;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

@RestController
public class CasaController {
    @PostMapping("/")
    @ResponseBody
    public CaracteristicasDTO informacoesCasa(@RequestBody Casa casa) throws JSONException {

        CaracteristicasDTO caracteristicasDTO = new CaracteristicasDTO();
        caracteristicasDTO.setMetrosQuadrados(casa.tamanhoCasa());
        caracteristicasDTO.setValor(casa.valorCasa());
        caracteristicasDTO.setMaiorComodo(casa.maiorComodo());
        caracteristicasDTO.setComodos(casa.tamanhoComodos());

        return caracteristicasDTO;
    }

}

/*

REQUEST BODY EXAMPLE:

    {
        "nome":"Casa 01",
        "endereco": "Rua aleatoria",
        "comodos":[
            {"nome": "quarto",
                "largura": 5,
                "comprimento": 6
            },
            {"nome": "sala",
                "largura": 7,
                "comprimento": 6
            },
            {"nome": "cozinha",
                "largura": 2,
                "comprimento": 3
            }
        ]
    }

 */
