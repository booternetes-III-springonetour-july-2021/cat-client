package com.example.catclient;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.support.TestPropertySourceUtils;

@AutoConfigureStubRunner(
	ids = "booternetes:cat-service:+:8080",
	stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
//@AutoConfigureWireMock (port = 8080)
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
