package br.com.marcello.FoodProject.controllers;

import br.com.marcello.FoodProject.dto.IngredientDto;
import br.com.marcello.FoodProject.dto.PlateDto;
import br.com.marcello.FoodProject.dto.PlateRequestBody;
import br.com.marcello.FoodProject.repositories.FoodRepository;
import br.com.marcello.FoodProject.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private FoodRepository foodRepositoryImpl;

    @Autowired
    private IngredientService ingredientServiceImpl;

    @GetMapping("/get")
    public ResponseEntity<List<IngredientDto>> healthCheck() {

        List<IngredientDto> ingredientsList = this.foodRepositoryImpl.loadIngredientsJson();
        return new ResponseEntity<>(ingredientsList, HttpStatus.OK);

    }

    @PostMapping("/getPlate")
    public ResponseEntity<PlateDto> getPlateJson(@RequestBody PlateRequestBody plateBody) {

        List<String> ingredientsName = plateBody.getIngredientsName();
        List<IngredientDto> ingredientDtos = new ArrayList<>();

        for(String name : ingredientsName) {
            IngredientDto ingredientDto = this.foodRepositoryImpl.findIngredientByName(name);
            ingredientDtos.add(ingredientDto);
        }

        PlateDto plateDto = new PlateDto();
        plateDto.setName(plateBody.getName());
        plateDto.setIngredientsList(ingredientDtos);
        plateDto.setTotalCalory(this.ingredientServiceImpl.getTotalCalories(ingredientDtos));
        plateDto.setMaxCaloryIngredient(this.ingredientServiceImpl.getMaxCaloriesIngredient(ingredientDtos));

        return new ResponseEntity<>(plateDto, HttpStatus.OK);

    }

}
