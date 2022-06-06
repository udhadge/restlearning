package zensar.restapi.testclasses;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;

public class TestClass {

	@Test
	public void test1() {
		baseURI = "https://demoqa.com/";
		
		given().get("BookStore/v1/Books").then().statusCode(200);
	}
	
	@Test
	public void test2() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		ResponseBody body = given().header("Content-Type","application/json").get("/posts/1").getBody();
		System.out.println(body.asString());
		//.then().statusCode(200).body(null, null);
	}
	
	@Test
	public void postData() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		JSONObject payLoad = new JSONObject();
		payLoad.put("title", "foo");
		payLoad.put("body", "bar");
		payLoad.put("userId", "1");
		
		//given().post("/posts",payLoad).then().statusCode(201);
	}
	
	@Test
	public void test3() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		
		String response = given().log().all().header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"title\": \"foo\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": 1\r\n"
				+ "}\r\n"
				+ "")
		.when().post("/posts")
		.then().log().all().assertThat().statusCode(201).body("title", equalTo("foo"))
		.header("Server", "cloudflare")
		.extract().asString();
		
		System.out.println("Response is :"+ response);
		
		JsonPath js = new JsonPath(response);
		String title = js.getString("title");
		System.out.println(title);
	}
	
	@Test
	public void test4() {
		baseURI = "https://jsonplaceholder.typicode.com/";
		Response response = given().get("/posts");
		String str = given().get("/posts").then().extract().asString();
		
		JsonPath js = new JsonPath(str);
		int count = js.getInt("size()");
		System.out.println(count);
		
		System.out.println(js);
		String title = js.getString("[0].title");
		System.out.println(title);
		
		JsonPath jp = response.jsonPath();
		String title1 = jp.get("[0].title");
		System.out.println(title1);
	}
	
	@Test
	public void test5() {
		baseURI = "https://jsonplaceholder.typicode.com/";
	
		String payload = "{\r\n"
				+ "    \"title\": \"%s\",\r\n"
				+ "    \"body\": \"bar\",\r\n"
				+ "    \"userId\": 1,\r\n"
				+ "    \"id\": 101\r\n"
				+ "}";
		
		String response = given().log().all().header("Content-Type","application/json")
		.body(String.format(payload, "foo"))
		.when().post("/posts")
		.then().log().all().assertThat().statusCode(201).body("title", equalTo("foo"))
		.header("Server", "cloudflare")
		.extract().asString();
		
		System.out.println("Response is :"+ response);
		
		JsonPath js = new JsonPath(response);
		String title = js.getString("title");
		System.out.println(title);
	}
	
	@Test
	public void test6() throws IOException {
		baseURI = "https://jsonplaceholder.typicode.com/";
		String inputJson = "D:\\eclipse_api_workspace\\zensar.restapi\\src\\test\\java\\zensar\\restapi\\testclasses\\input.json";
		given().log().all().header("Content-Type","application/json")
		.body(GenerateStringFromResource(inputJson))
		.when().post("/posts")
		.then().log().all().assertThat().statusCode(201).body("title", equalTo("foo"));
	}
		
	public static String GenerateStringFromResource(String path) throws IOException {
    return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	@Test
	public void strucure() {
		
		baseURI ="dfgffg";
		
		given().headers("Content-type", "json/text")
		.when().get("/fdfd")
		.then().statusCode(200).log().ifError();
		
		
	}
	
}
