package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.service.CharacterManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class CharacterManagerTest {

    @Autowired
    CharacterManager characterManager;

    @Autowired
    Character character1;
    @Autowired
    Character character2;
    @Autowired
    Character character3;
    @Autowired
    Character characterOther;

    @After
    public void close(){
        characterManager.delAll();
    }

    @Test
    public void addCharacterTest(){
        characterManager.addCharacter(character1);
        assertEquals(character1.getNick(),characterManager.getCharacterById(character1.getId()).getNick());
    }

    @Test
    public void getByIdTest(){
        characterManager.addCharacter(character1);
        assertEquals(character1.getNick(),characterManager.getCharacterById(character1.getId()).getNick());
    }

    @Test
    public void getByNickTest(){
        characterManager.addCharacter(character1);
        assertEquals(character1.getNick(),characterManager.getCharacterByNick(character1.getNick()).getNick());
    }

    @Test
    public void findByNickRegexTest(){
        //characterManager.addCharacter(character1);
        characterManager.addCharacter(character2);
        characterManager.addCharacter(character3);
        characterManager.addCharacter(characterOther);
        characterManager.addCharacter(new Character("Character4","Warrior","Human",50));
        List<Character> lista = characterManager.getCharacterByNickRegex("Character");
        //for(Character i : lista) System.out.println(i.getNick());
        assertEquals(3,lista.size());
    }

    @Test
    public void modifyCharacterTest(){
        characterManager.addCharacter(character1);
        String staryNick = characterManager.getCharacterById(character1.getId()).getNick();
        assertEquals(character1.getNick(),staryNick);
        character1.setNick("ZmienionyNick");
        characterManager.addCharacter(character1);
        assertEquals(character1.getNick(),characterManager.getCharacterById(character1.getId()).getNick());
        assertNull(characterManager.getCharacterByNick(staryNick));
    }

    @Test
    public void delCharacterTest(){
        characterManager.addCharacter(character1);
        characterManager.addCharacter(character2);
        List<Character> lista = characterManager.getAll();
        assertEquals(2,lista.size());
        characterManager.delCharacter(character2);
        lista = characterManager.getAll();
        assertEquals(1,lista.size());
        assertNull(characterManager.getCharacterById(character2.getId()));
    }

    @Test
    public void getAllTest() {
        characterManager.addCharacter(character1);
        characterManager.addCharacter(character2);
        characterManager.addCharacter(character3);
        characterManager.addCharacter(characterOther);
        List<Character> lista = characterManager.getAll();
        assertEquals(4,lista.size());
    }

    @Test
    public void delAllTest() {
        characterManager.addCharacter(character1);
        characterManager.addCharacter(character2);
        characterManager.addCharacter(character3);
        assertEquals(3,characterManager.getAll().size());
        characterManager.delAll();
        assertEquals(0,characterManager.getAll().size());
    }
}
