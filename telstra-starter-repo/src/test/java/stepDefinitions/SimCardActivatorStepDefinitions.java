package stepDefinitions;

import au.com.telstra.simcardactivator.ActivateController;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private String iccid;
    private ResponseEntity<String> response;

    @Given("the ICCID number is {String}")
    public void the_iccid_number_is(String iccid) {
        // Write code here that turns the phrase above into concrete actions
        String url = "http://localhost:8080/activate";
        response = restTemplate.postForEntity(url, iccid, String.class);
    }
    @When("I request this iccid to the SimCardActivatior")
    public void i_request_this_iccid_to_the_sim_card_activatior() {
        // Write code here that turns the phrase above into concrete actions
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        throw new io.cucumber.java.PendingException();
    }

    @Then("I will be told \"Successfully Activated\"")
    public void i_will_be_told_successfully_activated() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @And("查询端点结果确认为激活")
    public void the_activation_status_should_be_confirmed_using_the_query_endpoint(){
        String url = "http://localhost:8080/query/1";
        ResponseEntity<String> queryResponse = restTemplate.getForEntity(url, String.class);
        assertEquals("Activated", queryResponse.getBody());
    }

    @Then("I will be told \"Failed Activated\"")
    public void i_will_be_told_failed_activated() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @And("查询端点结果确认为失败")
    public void the_failure_status_should_be_confirmed_using_the_query_endpoint(){
        String url = "http://localhost:8080/query/2";
        ResponseEntity<String> queryResponse = restTemplate.getForEntity(url, String.class);
        assertEquals("Activation Failed", queryResponse.getBody());
    }
}