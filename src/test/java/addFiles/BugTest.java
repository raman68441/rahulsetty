package addFiles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;


public class BugTest {

	public static void main(String[] args) {
		
	String createIssueResponse=	RestAssured.baseURI="https://rahulsetty.atlassian.net";
		
given()
.header("Content-Type","application/json")
.header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB--NRrfh_CQgpaOWgheWx_HpR_1l5MImPkSK3Vs-P9PrA4Dv55ID5U0buLYyvOnz5xOfRCdMtj9-YqsKzvZzoVMh1QywZ8VqBzvMI=AA6CF65F")
.body("{\r\n"
		+ "    \"fields\": {\r\n"
		+ "       \"project\":\r\n"
		+ "       {\r\n"
		+ "          \"key\": \"SCRUM\"\r\n"
		+ "       },\r\n"
		+ "       \"summary\": \"REST ye merry gentlemen.\",\r\n"
		+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
		+ "       \"issuetype\": {\r\n"
		+ "          \"name\": \"Bug\"\r\n"
		+ "       }\r\n"
		+ "   }\r\n"
		+ "}")
.log().all()
.post("rest/api/3/issue").then().log().all().assertThat()
.extract().response().asString();

JsonPath js= new JsonPath(createIssueResponse);
String issueId=js.getString("id");
System.out.println(issueId);

given().pathParam("key", issueId)
.header("X-Atlassian-token","no-check")
.header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
.multiPart("file",new File("C:\\Users\\User\\Downloads/chakali santosh.jpg")).log().all()
.post("rest/api/3/issue/{key}/atachements")
.then().log().all().assertThat().statusCode(200);
	}

}
