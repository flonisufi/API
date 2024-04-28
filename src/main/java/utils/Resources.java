package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static stepDefinitions.AddPlace.place_id;

public class Resources {

    public RequestSpecification addReq(String value)
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .addQueryParam("key",value)
                .setContentType(ContentType.JSON)
                .build();
        return req;
    }

    public RequestSpecification getReq(String value)
    {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getProperty("baseUrl"))
                .addQueryParam("key",value)
                .addQueryParam("place_id",place_id)
                .setContentType(ContentType.JSON)
                .build();
        return req;
    }


    public String setJson(Response response,String key)
    {
        String resp = response.asString();
        JsonPath jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
