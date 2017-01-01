package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Character;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character,ObjectId> {

}
