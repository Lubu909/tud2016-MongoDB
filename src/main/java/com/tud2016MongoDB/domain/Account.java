package com.tud2016MongoDB.domain;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private ObjectId id;
    private String login;
    private String password;
    private Date registrationDate;
    private Date lastLogin;

    private List<Character> characterList = new ArrayList<Character>();

    public Account() {
        this.registrationDate = new Date();
        this.lastLogin = new Date();
    }

    public Account(ObjectId id, String login, String password, Date registrationDate, Date lastLogin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.lastLogin = lastLogin;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.registrationDate = new Date();
        this.lastLogin = new Date();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }
}
