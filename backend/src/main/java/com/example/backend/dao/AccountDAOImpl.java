package com.example.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.backend.Account;

@Repository
public class AccountDAOImpl implements  AccountDAO {
        private String name;
        private String serviceName;
        
    @Override
    public void addAccount(Account theAccount) {
       System.out.println(getClass()+ "doing my db work ;adding an account");
    }
    public String getName() {
        System.out.println(getClass()+"in getname");
        return name;
    }
    public void setName(String name) {
        System.out.println(getClass()+"in setname");
        this.name = name;
    }
    public String getServiceName() {
        System.out.println(getClass()+"in getServiceName");
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        System.out.println(getClass()+"in setServiceName");
        this.serviceName = serviceName;
    }
    @Override
    public List<Account> findAccounts() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'findAccounts'");
    List<Account> myAccount=new ArrayList<>();
    Account t1=new Account("john","Silver");
    Account t2=new Account("adi","Gold");
     Account t3=new Account("lol","Platinum");
     myAccount.add(t1);
     myAccount.add(t2);
     myAccount.add(t3);
 
     // Return the list of accounts
     return myAccount;
    }




}
