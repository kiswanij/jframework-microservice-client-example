package com.app;

import com.app.person.Model;
import com.app.person.ServiceClient;
import com.jk.util.JK;

public class App {
	public static void main(String[] args) {
		ServiceClient client=new ServiceClient();
		
		String response = client.callJsonAsString("/hello");
		JK.print(response);

		String response2 = client.callJsonAsString("/hello/Jalal");
		JK.print(response2);

		Model p = new Model();
		p.setName("Jalal");
		p.setAge(40);

		String response3 = client.callJsonWithPost("/hello", p);
		JK.print(response3);
	}
}
