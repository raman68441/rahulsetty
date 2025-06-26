package addFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import files.Payload;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;

public class DynamicJosn {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn,String aisle) throws IOException {
	RestAssured.baseURI="http://216.10.245.166";
	
	String response=given().log().all().header("Content-Type","application/json")
		//.body(Payload.AddBook("isbn","aisle"))
			.body(Files.readAllBytes(Paths.get("C:\\Users\\User\\Downloads\\ramank.txt")))
		.when().post(" Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
	
	JsonPath js= rahulesetty.ReUsableMethods.rawToJosn(response);
	String id=js.get("ID");
	
	System.out.println(id);
	}

	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//array =collection of elements 
		//multidimensional array= collection of arrays
		return new Object[][] {
			{"kdiek","1256"},{"dkiekd","45444"},{"diek","1314"}};
				
			
		///kdiekkaildke251464143161461614
		
	}
	
}
