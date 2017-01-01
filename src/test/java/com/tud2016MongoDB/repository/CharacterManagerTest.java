package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Character;
import com.tud2016MongoDB.service.CharacterManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.fail;

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

    @Test
    public void addCharacterTest(){
        fail("Not implemented!");
    }
}
