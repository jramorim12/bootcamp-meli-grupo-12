package br.com.marcello.StarWars.dto;

import java.util.List;

public class CharactersResponse {

    private List<CharacterDto> charactersList;

    public List<CharacterDto> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(List<CharacterDto> charactersList) {
        this.charactersList = charactersList;
    }
}
