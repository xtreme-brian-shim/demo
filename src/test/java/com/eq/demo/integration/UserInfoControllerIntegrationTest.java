package com.eq.demo.integration;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@Category(DemoIntegrationTest.class)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserInfoControllerIntegrationTest {

    @Value("${demo.baseUrl}")
    private String baseUrl;

    @Test
    public void testHome() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        assertThat(responseEntity.getBody().toString()).contains("Home Page");
    }
}
