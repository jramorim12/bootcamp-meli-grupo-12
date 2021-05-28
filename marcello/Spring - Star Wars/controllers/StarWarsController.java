package br.com.marcello.StarWars.controllers;

import br.com.marcello.StarWars.dto.CharacterDto;
import br.com.marcello.StarWars.dto.CharactersResponse;
import br.com.marcello.StarWars.repositories.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starWars")
public class StarWarsController {

    @Autowired
    private StarWarsRepository starWarsRepository;

    @GetMapping("/characters")
    public ResponseEntity<CharactersResponse> getCharacters(@RequestParam(value = "word") String word) {

        List<CharacterDto> charactersList = this.starWarsRepository.findCharactersByName(word);
        CharactersResponse response = new CharactersResponse();

        response.setCharactersList(charactersList);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
