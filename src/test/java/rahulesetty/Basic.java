package rahulesetty;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Basic {
	
	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://reqres.in/api";
		
		ValidatableResponse response=given().log().all().queryParam("key","page=2").headers("content-Type","application/json")
				.body(Payload.AddPlace()).when().post("users").then().log().all().statusCode(201);
		
		
	}

}
