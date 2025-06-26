package rahulesetty;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumeValidation {
	
	@Test
	public void sumOfCourses() {
		
		JsonPath js=new JsonPath(Payload.CoursePrice());
		
		int count= js.getInt("data.size()");
		int nameUrl=js.getInt("support.size()");
		System.out.println(nameUrl);
		for(int i=0;i<nameUrl;i++) {
			
		
			
			String title=js.getString("support["+i+"]");
			System.out.println(title);
//			if(title.equalsIgnoreCase("michael.lawson@reqres.in")) {
//				System.out.println(title);
//			}
			//System.out.println(title);
		
		}
		
		
	}

}
