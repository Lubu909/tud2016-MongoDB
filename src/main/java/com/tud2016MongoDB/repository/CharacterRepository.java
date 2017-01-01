package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Character;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character,ObjectId> {
    Character findByNick(String nick);

    @Query(value = "{ 'nick':{$regex:?0} }")
    List<Character> findByNickRegex(String regex);
}
