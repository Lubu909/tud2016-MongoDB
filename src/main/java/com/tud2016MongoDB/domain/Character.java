package com.tud2016MongoDB.domain;

import org.bson.types.ObjectId;

public class Character {
    private ObjectId id;
    private String nick;
    private String characterClass;
    private String characterRace;
    private int level;

    public Character() {
    }

    public Character(String nick, String characterClass, String characterRace, int level) {
        this.nick = nick;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.level = level;
    }

    public Character(ObjectId id, String nick, String characterClass, String characterRace, int level) {
        this.id = id;
        this.nick = nick;
        this.characterClass = characterClass;
        this.characterRace = characterRace;
        this.level = level;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(String characterRace) {
        this.characterRace = characterRace;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
