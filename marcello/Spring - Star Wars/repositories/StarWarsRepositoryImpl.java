package br.com.marcello.StarWars.repositories;

import br.com.marcello.StarWars.dto.CharacterDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    public List<CharacterDto> initRepo() {

        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDto>> typeReference = new TypeReference<List<CharacterDto>>() {};
        List<CharacterDto> starWarsCharacters = null;

        try {
            starWarsCharacters = objectMapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return starWarsCharacters;

    }

    @Override
    public List<CharacterDto> findCharactersByName(String word) {

        List<CharacterDto> starWarsCharacters = null;
        starWarsCharacters = this.initRepo();
        List<CharacterDto> characters = null;

        if(starWarsCharacters != null) {
            characters = starWarsCharacters.stream()
                    .filter(characterDto -> characterDto.getName().toLowerCase().contains(word.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return characters.size() > 0 ? characters : this.initNotFoundResponse(word);
    }

    private List<CharacterDto> initNotFoundResponse(String word) {

        CharacterDto notFound = new CharacterDto();
        notFound.setName("No characters found containing the following word: " + word);
        List<CharacterDto> notFoundResponse = new ArrayList<>();
        notFoundResponse.add(notFound);

        return notFoundResponse;
    }

}
