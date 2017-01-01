package com.tud2016MongoDB.service;

import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.repository.CharacterRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public Character getCharacterByNick(String nick){
        return characterRepository.findByNick(nick);
    }

    public List<Character> getCharacterByNickRegex(String regex){
        return characterRepository.findByNickRegex(regex);
    }

    public List<Character> getAll(){
        Iterable<Character> it = characterRepository.findAll();
        List<Character> lista = new ArrayList<Character>();
        for (Character item : it) lista.add(item);
        return lista;
    }

    public void delAll(){
        characterRepository.deleteAll();
    }
}
