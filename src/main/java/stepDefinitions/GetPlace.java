package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import utils.Resources;

import static io.restassured.RestAssured.given;

public class GetPlace extends Resources {

    RequestSpecification req;
    Response response;

    @Given("User enter query parameter {string} and place_id")
    public void user_enter_query_parameter_and_place_id(String query)
    {
        req = given().spec(getReq(query));

    }
    @When("User calls Get http request")
    public void user_calls_get_http_request()
    {
        response = req.when().get("/maps/api/place/get/json");

    }
    @Then("User Get call for success with status code {int}")
    public void user_get_call_for_success_with_status_code(Integer statusCode)
    {
        Assert.assertEquals(response.getStatusCode(),statusCode);

    }
    @Then("Validate that address is {string}")
    public void validate_that_address_is(String expectedAddress)
    {
        String actualAddress = setJson(response,"address");
        Assert.assertEquals(actualAddress,expectedAddress);
    }
}
