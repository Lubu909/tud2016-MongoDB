package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,ObjectId> {
    Account findByLogin(String login);

    @Query(value = "{ 'login':{$regex:?0} }")
    List<Account> findByLoginRegex(String regex);
}
