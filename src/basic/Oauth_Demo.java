package basic;


import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import POJO.Api;
import POJO.GetCourses;
import POJO.WebAutomation;
public class Oauth_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] coursetitles= {"Selenium Webdriver Java","Cypress","Protractor"};
		
		//Get COde
		String url="https://rahulshettyacademy.com/getCourse.php?state=verifyjdss&code=4%2F0AX4XfWiXp4N3nwA9GiJM-ypZzOgowKY8fChZegnGTENInS3eSyXon_7Qp95ilq6UZlvuPw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode=url.split("&code=")[1];
		String code= partialcode.split("&scope")[0];
		
		
		
		//GetToken
		String tokenresponse=given().relaxedHTTPSValidation().urlEncodingEnabled(false)//urlencodingenabled will allows to manioulate speciale characters in URL(false means dont change special characters to numeric value)
		.queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js= new JsonPath(tokenresponse);
	    String token=js.getString("access_token");// this will store the access token

		
		//GetCourseContent
		GetCourses gc=given().relaxedHTTPSValidation()
		.queryParam("access_token", token).expect().defaultParser(Parser.JSON)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);
 
		/*
		 * System.out.println(gc.getServices());
		 * System.out.println(gc.getCourses().getWebAutomation().get(1).getCourseTitle()
		 * );
		 */
		
		System.out.println("LinkedIN Title" +gc.getLinkedIn());
		List<Api> apicourse= gc.getCourses().getApi();
		for(int i=0; i<apicourse.size();i++)
		{
			apicourse.get(i).getCourseTitle();
			if(apicourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println("Price of SoapUI Webservices testing " +apicourse.get(i).getPrice());
				
			}
		}
		
		ArrayList<String> actual= new ArrayList<String>();
		List<WebAutomation> autocourse= gc.getCourses().getWebAutomation();
		
		for(int j=0; j<autocourse.size();j++)
		{
			actual.add(autocourse.get(j).getCourseTitle());
			
		}
		
		List<String> expected=Arrays.asList(coursetitles);
		
		Assert.assertTrue(actual.equals(expected));
	}

}
