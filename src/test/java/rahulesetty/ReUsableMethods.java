package rahulesetty;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	 
	public static JsonPath rawToJosn(String response) {
  JsonPath js= new JsonPath(response);
		return js;
		
		
	}

}
