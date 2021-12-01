package basic;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import files.Payload;
import files.ReusabaleMethods;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI="http://localhost:8080/";
		SessionFilter session= new SessionFilter();
		//CreateSession
		given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.body(Payload.CreateSession("apoorvr", "Welcome123")).filter(session).when().post("rest/auth/1/session").then().log()
				.all().assertThat().statusCode(200).body("session.name", equalTo("JSESSIONID")).extract().response()
				.asString();
			
		
		//Create Issue
		String idresponse=given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json")
				.body(Payload.CreateIssue()).filter(session).when().post("rest/api/2/issue")
				.then().log().all().assertThat().statusCode(201).extract()
				.response().asString();
		JsonPath js_id= ReusabaleMethods.rawToJson(idresponse);
		String id_issue=js_id.getString("id");   //Issue id
		System.out.println(id_issue);
		
		//Add comment
		String comment_response=given().relaxedHTTPSValidation().pathParam("id_key", id_issue).log().all().header("Content-Type", "application/json")
				.body(Payload.AddComment()).filter(session).when().post("rest/api/2/issue/{id_key}/comment")
				.then().log().all().assertThat().statusCode(201).extract()
				.response().asString();
		JsonPath js_co= ReusabaleMethods.rawToJson(comment_response);
		String co_id= js_co.getString("id");  //Comment id
		
		//Add Attachment
		given().relaxedHTTPSValidation().header("X-Atlassian-Token", "no-check").pathParam("id_key", id_issue)
				.header("Content-Type", "multipart/form-data").multiPart("file", new File("attachment.txt"))
				.filter(session).when().post("/rest/api/2/issue/{id_key}/attachments").then().log().all().assertThat()
				.statusCode(200);
		
		//UpdateComment
		given().relaxedHTTPSValidation().pathParam("id_key", id_issue).pathParam("id_co", co_id).log().all().header("Content-Type", "application/json")
		.body(Payload.UpdateComment()).filter(session)
		.when().put("rest/api/2/issue/{id_key}/comment/{id_co}")
		.then().log().all().assertThat().statusCode(200).extract()
		.response().asString();
		
		//Get Issue Details
		String issueresponse=given().relaxedHTTPSValidation().queryParam("fields", "comment").pathParam("id_key", id_issue).log().all().filter(session)
		.when().get("/rest/api/2/issue/{id_key}").then().log().all().assertThat().statusCode(200).extract().response().asString();
	     
		JsonPath js_issue=ReusabaleMethods.rawToJson(issueresponse);
		int comment_size=js_issue.get("fields.comment.comments.size()");
		
		for(int i=0;i<comment_size;i++)
		{
			String commentid=js_issue.get("fields.comment.comments["+i+"].id");
			if(commentid.equalsIgnoreCase(co_id))
			{
				String comment=js_issue.get("fields.comment.comments["+i+"].body");
				System.out.println(comment);
				break;
			}
			
		}
	}

}
