package com.example.catclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class CatClientApplicationTests {

	@Autowired
	private CatClient client;


	@Test
	void contextLoads() {

		/*
			WireMock
			.stubFor(WireMock
				.get("/cats/Toby")
				.willReturn(
					WireMock
						.aResponse()
						.withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
						.withBody("  { \"id\":\"1\", \"name\":\"Toby\" }  ")
				));
				*/
		var result = this.client.getCatByName("Toby");
		Assertions.assertEquals(result.getName(), "Toby");

	}

}
