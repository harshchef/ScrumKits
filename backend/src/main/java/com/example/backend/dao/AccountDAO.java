package com.example.backend.dao;

import java.util.List;

import com.example.backend.Account;

public interface AccountDAO {
    public void addAccount(Account theAccount);
    List<Account> findAccounts();
}
