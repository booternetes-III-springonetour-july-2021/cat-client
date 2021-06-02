package com.example.catclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatClient {

	private final RestTemplate restTemplate;
	private final String hostname;
	private final int port;

	public CatClient(RestTemplate restTemplate,
																		@Value("${cats.host}") String hostname,
																		@Value("${cats.port}") int port) {
		this.restTemplate = restTemplate;
		this.hostname = hostname;
		this.port = port;
	}

	Cat getCatByName(String name) {
		return this.restTemplate.getForObject("http://" + this.hostname +
			":" + this.port + "/cats/{name}", Cat.class, name);
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Cat {
	private Integer id;
	private String name;
}
