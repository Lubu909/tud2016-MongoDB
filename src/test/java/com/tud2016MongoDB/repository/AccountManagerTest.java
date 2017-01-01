package com.tud2016MongoDB.repository;

import com.tud2016MongoDB.domain.Account;
import com.tud2016MongoDB.service.AccountManager;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class AccountManagerTest {

    @Autowired
    private AccountManager accountManager;

    @Autowired
    private Account account1;
    @Autowired
    private Account account2;
    @Autowired
    private Account account3;
    @Autowired
    private Account accountOther;

    @After
    public void close(){
        accountManager.delAll();
    }

    @Test
    public void addAccountTest(){
        accountManager.addAccount(account1);
        assertEquals(account1.getLogin(),accountManager.getAccountById(account1.getId()).getLogin());
    }

    @Test
    public void getByLoginTest(){
        accountManager.addAccount(account2);
        assertEquals(account2.getId(),accountManager.getAccountByLogin(account2.getLogin()).getId());
    }

    @Test
    public void getByIdTest() {
        accountManager.addAccount(account2);
        assertEquals(account2.getLogin(),accountManager.getAccountById(account2.getId()).getLogin());
    }

    @Test
    public void findByLoginRegexTest() throws InterruptedException {
        accountManager.addAccount(account2);
        accountManager.addAccount(account3);
        accountManager.addAccount(new Account("Account5","hasło"));
        accountManager.addAccount(accountOther);
        List<Account> lista = accountManager.getByAccountRegex("Account");
        for(Account i : lista) System.out.println(i.getLogin());
        assertEquals(3,lista.size());
    }

    @Test
    public void modifyAccountTest() {
        accountManager.addAccount(account1);
        String staryLogin = accountManager.getAccountById(account1.getId()).getLogin();
        assertEquals(account1.getLogin(),staryLogin);
        account1.setLogin("ZmienionyLogin");
        accountManager.addAccount(account1);
        assertEquals(account1.getLogin(),accountManager.getAccountById(account1.getId()).getLogin());
        assertNull(accountManager.getAccountByLogin(staryLogin));
    }

    @Test
    public void delAccountTest() {
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);
        List<Account> lista = accountManager.getAll();
        assertEquals(2,lista.size());
        accountManager.delAccount(account2);
        lista = accountManager.getAll();
        assertEquals(1,lista.size());
        assertNull(accountManager.getAccountById(account2.getId()));
    }

    @Test
    public void getAllTest() {
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);
        accountManager.addAccount(account3);
        accountManager.addAccount(accountOther);
        List<Account> lista = accountManager.getAll();
        assertEquals(4,lista.size());
    }

    @Test
    public void delAllTest(){
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);
        accountManager.addAccount(account3);
        assertEquals(3,accountManager.getAll().size());
        accountManager.delAll();
        assertEquals(0,accountManager.getAll().size());
    }
}
