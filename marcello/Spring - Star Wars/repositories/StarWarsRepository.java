package br.com.marcello.StarWars.repositories;

import br.com.marcello.StarWars.dto.CharacterDto;

import java.util.Collection;
import java.util.List;

public interface StarWarsRepository {

    List<CharacterDto> findCharactersByName(String word);

}
