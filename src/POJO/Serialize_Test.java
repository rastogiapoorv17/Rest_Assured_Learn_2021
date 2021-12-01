package POJO;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Serialize_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		AddPlace add = new AddPlace();
		Location loc= new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setLocation(loc);
		add.setAccuracy(50);
		add.setName("Rahul Shetty Academy");
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress("29, side layout, cohen 09");
		add.setLanguage("French-IN");
		add.setWebsite("http://google.com");
		List<String> list= new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		add.setTypes(list);
		
		
	
		
		RequestSpecification reqspec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setRelaxedHTTPSValidation().addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification respspec= new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		RequestSpecification req= given().log().all().spec(reqspec).body(add);
		
		Response res=req.when().post("/maps/api/place/add/json").
		then().log().all().spec(respspec).extract().response();
		
		String response=res.asString();
		System.out.println(response);
		
		
	}

}
