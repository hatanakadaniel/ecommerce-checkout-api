package com.hatanaka.ecommerce.checkout.steps;

import com.hatanaka.ecommerce.checkout.SpringIntegrationTest;
import com.hatanaka.ecommerce.checkout.util.UUIDUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class StepDefinitions extends SpringIntegrationTest {

    @Autowired
    protected TestRestTemplate template;
    @Mock
    private UUIDUtil uuidUtil;
    private String responseBody;

    private HttpHeaders responseHeaders;

    private HttpStatus statusCode;

    private static String getBody(ResponseEntity response) {
        final StringBuilder body = new StringBuilder();
        if (response.getBody() != null) {
            body.append(response.getBody().toString());
        }
        return body.toString();
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCode.value());
    }

    @When("the client calls {string}")
    public void theClientCalls(String path) throws IOException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            final String body = "{\n" +
                    "\t\"firstName\": \"\",\n" +
                    "\t\"lastName\": \"\",\n" +
                    "\t\"username\": \"\",\n" +
                    "\t\"email\": \"\",\n" +
                    "\t\"address\": \"\",\n" +
                    "\t\"complement\": \"\",\n" +
                    "\t\"country\": \"\",\n" +
                    "\t\"state\": \"\",\n" +
                    "\t\"cep\": \"\",\n" +
                    "\t\"saveAddress\": \"\",\n" +
                    "\t\"saveInfo\": \"\",\n" +
                    "\t\"paymentMethod\": \"\",\n" +
                    "\t\"cardName\": \"\",\n" +
                    "\t\"cardNumber\": \"\",\n" +
                    "\t\"cardDate\": \"dasd\",\n" +
                    "\t\"cardCvv\": \"sadasd\",\n" +
                    "\t\"products\": [\n" +
                    "\t\t\t\"produtoA\",\n" +
                    "\t\t\t\"produtoB\"\n" +
                    "\t\t]\n" +
                    "}";

            HttpEntity<String> entity = new HttpEntity<>(body, headers);
            final ResponseEntity<?> response = template.postForEntity(
                    path,
                    entity,
                    String.class);
            responseBody = getBody(response);
            responseHeaders = response.getHeaders();
            statusCode = response.getStatusCode();
        } catch (HttpStatusCodeException ex) {
            statusCode = ex.getStatusCode();
            assertEquals("", ex.getResponseBodyAsString());
        }
    }

    @And("response is {string}")
    public void responseIs(String expectedResponseBody) {
        assertEquals(expectedResponseBody, responseBody);
    }

    @Given("checkout code {string}")
    public void checkoutCode(String checkoutCode) {
        MockitoAnnotations.initMocks(this);
        Mockito.when(uuidUtil.createUUID()).thenReturn(UUID.fromString(checkoutCode));
    }
}
