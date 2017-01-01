package com.tud2016MongoDB.service;

import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.repository.CharacterRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterManager {
    @Autowired
    CharacterRepository characterRepository;

    public void addCharacter(Character character){
        characterRepository.save(character);
    }

    public void delCharacter(Character character){
        characterRepository.delete(character);
    }

    public Character getCharacterById(ObjectId id){
        return characterRepository.findOne(id);
    }
}
