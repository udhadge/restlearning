package zensar.restapi.testclasses;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestRestAssured {

	
	@Test
	public void test1() {
		RestAssured.baseURI = "fdf";
		
		RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
     
        requestParams.put("id", "2937");
        //requestParams.put("name", "jai ram");
        requestParams.put("email", "jaiffhtuh@asd.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "inactive");
               
        request.header("Content-Type","application/json");
        request.auth().oauth2("2b2827af9b0409be1826da53ce74cb10c6ed78039e749c8dacb7f90cb8cfe0ef");
        request.body(requestParams.toJSONString());
        Response response = request.post("/public/v2/users");

        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 201);
       // String userID = response.getBody().jsonPath().getString("userID");
	}
	
	@Test
	public void test2() {
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
		
		OAuth2Scheme authScheme = new OAuth2Scheme();
	    authScheme.setAccessToken("2b2827af9b0409be1826da53ce74cb10c6ed78039e749c8dacb7f90cb8cfe0ef");
	    RestAssured.authentication = authScheme;
		RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").setAuth(authScheme).build();
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
	
		Response res = RestAssured.given(requestSpec, responseSpec).get("/posts/10");
		System.out.println(res.asString());
	}
	
	@Test
	public void test3() {
		
		RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
     
        requestParams.put("title", "foo");
        requestParams.put("body", "7");
        requestParams.put("userId", "jj");
                  
        request.header("Content-Type","application/json");
        request.pathParam("id", 22);
        Response response = request.post("/posts/{id}");

        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test
	public void testGetEmployeeWithPathParam() {
	Response empResponse = given().
	          baseUri("http://localhost:8080").
	          contentType(ContentType.JSON).
	          pathParam("id", "33").
	          when().
	          get("/employee/{id}").
	          then().
	          log().all().
	          assertThat().
	          statusCode(200).
	          extract().
	          response();

	   JsonPath jsonPathObj = empResponse.jsonPath();
	   Assert.assertEquals(jsonPathObj.getLong("id"), 33);
	}
	
	@Test
	public void test4() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		String responseStr = given().get("/posts").then().extract().asString();
		
		JsonPath js = new JsonPath(responseStr); //pass string response to jsonpath
		
		String title = js.getString("[0].title");
		System.out.println(title);
		
		//$.[?(@.id ==10)]
		//$.[?(@.id ==5 && @.userId==1)]
		// shopping.category.find { it.@type == 'groceries' }
		
		String conditionalResponse = js.getString("[id == 10]");
		System.out.println(conditionalResponse);
	}
	
	/*
	 * Test response time of request
	 */
	@Test
	public void testTime() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		String res = given().header("Content-Type","application/json")
		.when().get("/posts/1")
		.then().time(lessThan(1500L)).extract().asString();
		
		System.out.println(res);
	}
	
	/*
	 * Log iferror
	 */
	@Test
	public void testError() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		given().header("Content-Type","application/json").get("/posts/1")
		.then().statusCode(300).log().ifError();
	}
	
	
	
}


