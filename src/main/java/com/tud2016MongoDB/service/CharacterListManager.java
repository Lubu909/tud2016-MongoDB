package com.tud2016MongoDB.service;

import com.tud2016MongoDB.domain.Account;
import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CharacterListManager {
    @Autowired
    AccountManager accountManager;

    public void addCharacterToAccount(Account account, Character character){
        Account acc =  accountManager.getAccountById(account.getId());
        acc.getCharacterList().add(character);
        accountManager.addAccount(acc);
    }

    public void delCharacterFromAccount(Account account, Character character){
        Account acc = accountManager.getAccountById(account.getId());
        List<Character> characters = getCharacterList(account);
        List<Character> charactersNext = new ArrayList<Character>();
        for(Character chara : characters){
            if(!chara.getNick().equals(character.getNick())) charactersNext.add(chara);
        }
        acc.setCharacterList(charactersNext);
        accountManager.addAccount(acc);
    }

    public void delCharactersLowerThan(Account account, int lvl){
        Account acc = accountManager.getAccountById(account.getId());
        List<Character> characters = getCharacterList(account);
        List<Character> charactersNext = new ArrayList<Character>();
        for(Character character : characters){
            if(character.getLevel()>=lvl) charactersNext.add(character);
        }
        acc.setCharacterList(charactersNext);
        accountManager.addAccount(acc);
    }

    public List<Character> getCharacterList(Account account){
        Account acc = accountManager.getAccountById(account.getId());
        return acc.getCharacterList();
    }
}
