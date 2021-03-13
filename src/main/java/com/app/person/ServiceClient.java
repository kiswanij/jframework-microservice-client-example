package com.app.person;

import com.jk.util.config.JKConfig;
import com.jk.web.services.client.JKServiceClient;

public class ServiceClient extends JKServiceClient<Model> {
	@Override
	public String getBase() {
		return JKConfig.getDefaultInstance().getProperty("services.example.url");
	}

	public String callSayHello() {
		return callJsonAsString("/hello");
	}
	
	public String callSayHelloWithName(String name) {
		return callJsonAsString("/hello/"+name);
	}
	
	public String callSayHelloWithObject(Model p) {
		return callJsonWithPost("/hello", p);	
	}
	
}
