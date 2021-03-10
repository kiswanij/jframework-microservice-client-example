package com.app;


import java.util.List;

import com.app.model.Account;
import com.jk.util.JK;
import com.jk.web.services.client.JKServiceClient;

public class App {
	public static void main(String[] args) {
		JKServiceClient<Account> client=new JKServiceClient<Account>("http://localhost:8080/app/accounts", Account.class);

		// Retrieve all account
		List<Account> list = client.callJsonAsListOfObjects();

		for (Account account : list) {
			JK.print(account);
		}
		// Retrieve single account
		Account account = client.callSingleJson("/1");
		JK.printBlock(account);
		
	}
}
