package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.AddPage;
import utils.Resources;

import static io.restassured.RestAssured.*;

public class AddPlace extends Resources {

    RequestSpecification req;
    Response response;
    AddPage addPage = new AddPage();

    public static String place_id;

    @Given("User Payload with informations and query parameter {string}")
    public void user_payload_with_informations_and_query_parameter(String value)
    {
        req = given().spec(addReq(value)).body(addPage.addPayload());

    }

    @When("User calls Post http request")
    public void user_calls_post_http_request()
    {
        response = req.when().post("/maps/api/place/add/json");

    }

    @Then("User call for success with status code {int}")
    public void user_call_for_success_with_status_code(Integer statusCode)
    {
        Assert.assertEquals(response.getStatusCode(),statusCode);
        place_id = setJson(response,"place_id");
        System.out.println(place_id);

    }

    @Then("Validate that status is {string}")
    public void validate_that_status_is(String expectedStatus)
    {
       String actualStatus = setJson(response,"status");
       Assert.assertEquals(actualStatus,expectedStatus);
    }
}
