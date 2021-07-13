package com.example.catclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;

@AutoConfigureStubRunner(
        ids = "booternetes:cat-service:+:8080",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
@SpringBootTest
class CatClientApplicationTests {

    @Autowired
    private CatClient client;

    @Test
    void clientShouldCallAndReturnCat() {
        var result = this.client.getCatByName("Toby");
        Assertions.assertEquals(result.getName(), "Toby");
    }
}
