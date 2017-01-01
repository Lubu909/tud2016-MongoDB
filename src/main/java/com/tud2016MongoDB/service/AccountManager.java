package com.tud2016MongoDB.service;

import com.tud2016MongoDB.domain.Account;
import com.tud2016MongoDB.repository.AccountRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountManager {
    @Autowired
    AccountRepository accountRepository;

    public void addAccount(Account account){
        accountRepository.save(account);
    }

    public void delAccount(Account account){
        accountRepository.delete(account);
    }

    public Account getAccountById(ObjectId id){
        return accountRepository.findOne(id);
    }

    public Account getAccountByLogin(String login){
        return accountRepository.findByLogin(login);
    }

    public List<Account> getByAccountRegex(String regex){
        return accountRepository.findByLoginRegex(regex);
    }

    public List<Account> getAll(){
        Iterable<Account> it = accountRepository.findAll();
        List<Account> lista = new ArrayList<Account>();
        for (Account item : it) lista.add(item);
        return lista;
    }

    public void delAll(){
        accountRepository.deleteAll();
    }
}
