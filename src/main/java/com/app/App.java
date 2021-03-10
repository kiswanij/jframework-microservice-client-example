package com.app;


import java.util.List;

import com.app.model.Account;
import com.jk.util.JK;
import com.jk.web.services.client.JKServiceClient;

public class App {
	public static void main(String[] args) {
		JKServiceClient<Account> client=new JKServiceClient<Account>("http://localhost:8080/app/accounts", Account.class);
		Account account=new Account();
		account.setNumber("1234");
		account.setName("Jalal");
		account.setAvg(100.3);
		account.setPhone("88888");
		client.callJsonWithPost(account);
		
		// Retrieve all account
		List<Account> list = client.callJsonAsListOfObjects();

		for (Account record: list) {
			JK.print(record);
		}
		// Retrieve single account
		account = client.callSingleJson("/1");
		JK.printBlock(account);
		
	}
}
