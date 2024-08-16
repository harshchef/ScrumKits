package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	// @Bean
	// public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO  ,TrafficFortuneService thetrafficfortune){
	// 	return runner ->{
	// 		demotheBeforeAdvice(theAccountDAO);
	// 		demoTheAfterAdvice(theAccountDAO);
			
	// 	};
	// }

	// private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
	// 	System.out.println("After advice");
	//  List<Account>  theAccounts=theAccountDAO.findAccounts();
	// System.out.println(theAccounts);
	// }

	// private void demotheBeforeAdvice(AccountDAO theAccountDAO) {
	// 	// TODO Auto-generated method stub

	// 	Account myAccount=new Account("jOHN","LEVEL1");

	// 	theAccountDAO.addAccount(myAccount);
	// }

}
