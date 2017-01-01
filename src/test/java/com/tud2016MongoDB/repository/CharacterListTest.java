package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Account;
import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.service.AccountManager;
import com.tud2016MongoDB.service.CharacterManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class CharacterListTest {
    @Autowired
    CharacterManager characterManager;
    @Autowired
    AccountManager accountManager;

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

    @Test
    public void addCharacterToList() {
        fail("Not implemented!");
    }

    @Test
    public void delCharacterFromList() {
        fail("Not implemented!");
    }

    @Test
    public void delCharactersOlderThan(){
        fail("Not implemented!");
    }

    @Test
    public void getCharacterList() {
        fail("Not implemented!");
    }
}
