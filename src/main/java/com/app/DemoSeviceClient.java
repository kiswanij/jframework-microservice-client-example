package com.app;

import static org.mockito.ArgumentMatchers.matches;

import com.jk.core.config.JKConfig;
import com.jk.core.util.JK;
import com.jk.services.client.JKServiceClient;

public class DemoSeviceClient extends JKServiceClient<Person> {

	@Override
	public String getBase() {
		return JKConfig.get().getProperty("example.service.url", "http://localhost:8080/app/example");
	}

	public String hello() {
		return callJsonAsString("/hello");
	}

	public String hellowithParam(String name) {
		return callJsonAsString("/hello/" + name);
	}

	public String helloWithModel(Person p) {
		return callJsonWithPost("/hello", p);
	}
	
	public static void main(String[] args) {
		DemoSeviceClient client=new DemoSeviceClient();
		JK.print(client.hello());
		JK.print(client.hellowithParam("Jalal"));
	}

}