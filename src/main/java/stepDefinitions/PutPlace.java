package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pages.PutPage;
import utils.Resources;

import static io.restassured.RestAssured.*;

public class PutPlace extends Resources {

    RequestSpecification req;
    Response response;

    PutPage putPage = new PutPage();

    @Given("User Payload and query parameters {string} and place_id")
    public void user_payload_and_query_parameters_and_place_id(String query)
    {
        req = given().spec(getReq(query)).body(putPage.putPayload());

    }
    @When("User calls Put http request")
    public void user_calls_put_http_request()
    {
        response = req.when().put("/maps/api/place/update/json");

    }
    @Then("User Put call for success with status code {int}")
    public void user_put_call_for_success_with_status_code(Integer statusCode)
    {
        Assert.assertEquals(response.getStatusCode(),statusCode);


    }
    @Then("Validate that address is changed")
    public void validate_that_address_is_changed()
    {
        String message = setJson(response,"msg");
        Assert.assertEquals(message,"Address successfully updated");

    }
}
