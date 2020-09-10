package com.hatanaka.ecommerce.checkout.steps;

import com.hatanaka.ecommerce.checkout.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions extends SpringIntegrationTest {

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int arg0) {
        Assert.assertEquals(200, arg0);
    }

    @And("the client receives server version {double}")
    public void theClientReceivesServerVersion(int arg0, int arg1) {
    }

    @When("the client calls {string}")
    public void theClientCalls(String arg0) {
    }
}
