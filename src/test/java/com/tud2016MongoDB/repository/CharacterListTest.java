package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Account;
import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.service.AccountManager;
import com.tud2016MongoDB.service.CharacterListManager;
import com.tud2016MongoDB.service.CharacterManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class CharacterListTest {
    @Autowired
    CharacterManager characterManager;
    @Autowired
    AccountManager accountManager;
    @Autowired
    CharacterListManager characterListManager;

    @Autowired
    Account account1;
    @Autowired
    Account account2;
    @Autowired
    Account account3;
    @Autowired
    Character character1;
    @Autowired
    Character character2;
    @Autowired
    Character character3;

    @After
    public void clear(){
        accountManager.delAll();
        characterManager.delAll();
    }

    @Test
    public void addCharacterToList() {
        accountManager.addAccount(account1);
        characterListManager.addCharacterToAccount(accountManager.getAccountById(account1.getId()),character1);
        assertEquals(1,characterListManager.getCharacterList(accountManager.getAccountById(account1.getId())).size());
        assertEquals(1,accountManager.getAll().size());
    }

    @Test
    public void delCharacterFromList() {
        accountManager.addAccount(account1);
        Account account = accountManager.getAccountById(account1.getId());
        characterManager.addCharacter(character1);
        Character character = characterManager.getCharacterByNick(character1.getNick());
        characterListManager.addCharacterToAccount(account,character);
        List<Character> characters = characterListManager.getCharacterList(account);
        assertEquals(1,characters.size());
        assertEquals(1,accountManager.getAll().size());
        characterListManager.delCharacterFromAccount(account,characters.get(0));
        characters = characterListManager.getCharacterList(account);
        assertEquals(0,characters.size());
    }

    @Test
    public void delCharactersLowerThan(){
        accountManager.addAccount(account2);
        Account account = accountManager.getAccountById(account2.getId());
        characterManager.addCharacter(character1);
        characterManager.addCharacter(character2);
        characterManager.addCharacter(character3);
        Character char1 = characterManager.getCharacterByNick(character1.getNick());
        Character char2 = characterManager.getCharacterByNick(character2.getNick());
        Character char3 = characterManager.getCharacterByNick(character3.getNick());
        characterListManager.addCharacterToAccount(account,char1);
        characterListManager.addCharacterToAccount(account,char2);
        characterListManager.addCharacterToAccount(account,char3);
        List<Character> characters = characterListManager.getCharacterList(account);
        assertEquals(3,characters.size());
        characterListManager.delCharactersLowerThan(account,100);
        characters = characterListManager.getCharacterList(account);
        //for(Character character : characters) System.out.println(character.getNick() + ", " + character.getLevel());
        assertEquals(1,characters.size());
    }

    @Test
    public void getCharacterList() {
        accountManager.addAccount(account1);
        characterListManager.addCharacterToAccount(account1,character1);
        characterListManager.addCharacterToAccount(account1,character2);
        characterListManager.addCharacterToAccount(account1,character3);
        assertEquals(3,characterListManager.getCharacterList(account1).size());
    }
}
