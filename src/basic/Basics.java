package basic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import files.Payload;
import files.ReusabaleMethods;
public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json")
		        .then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP"))
		        .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		//System.out.println(response);
		
		JsonPath js=ReusabaleMethods.rawToJson(response);
		String placeId=js.getString("place_id");
	
		
		//Update the place=
		String newAddress = "75 Summer walk, USA";
		given().relaxedHTTPSValidation().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(Payload.UpdatePlace(placeId,newAddress)).when().put("maps/api/place/update/json")
				        .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get the Place
		String getPlaceresponse=given().relaxedHTTPSValidation().log().all().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).body("address", equalTo(newAddress)).extract().response().asString();
		
		JsonPath js1= ReusabaleMethods.rawToJson(getPlaceresponse);
		String actual_addrss=js1.getString("address");
	    Assert.assertEquals(actual_addrss, newAddress);
	}
	
	
}



