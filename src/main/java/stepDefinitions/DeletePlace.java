package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.DeletePage;
import utils.Resources;

import static io.restassured.RestAssured.*;

public class DeletePlace extends Resources {

    RequestSpecification req;
    Response response;

    DeletePage deletePage = new DeletePage();

    @Given("User Payload and query paramter {string}")
    public void user_payload_and_query_paramter(String query)
    {
        req = given().spec(addReq(query)).body(deletePage.deletePayload());

    }

    @When("User calls Delete with http request")
    public void user_calls_delete_with_http_request()
    {
        response = req.when().delete("/maps/api/place/delete/json");

    }

    @Then("User Delete call for success with status code {int}")
    public void user_delete_call_for_success_with_status_code(Integer statusCode)
    {
        Assert.assertEquals(response.getStatusCode(),statusCode);

    }

    @Then("Validate that status response is {string}")
    public void validate_that_status_response_is(String expectedStatus)
    {
        String actualStatus = setJson(response,"status");
        Assert.assertEquals(actualStatus,expectedStatus);

    }
}
