package basic;

import org.testng.annotations.*;

import files.Payload;
import files.ReusabaleMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJsonExample {
	
	@Test(dataProvider = "BookData")
	public void AddBook(String isbn, String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json")
		.body(Payload.AddBook(isbn,aisle))
		.when().post("Library/Addbook.php ")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReusabaleMethods.rawToJson(response);
	   String id= js.get("ID");
	   System.out.println(id);
	   
	 
	}
	@Test(dataProvider = "BookData")
	public void DeleteBook(String isbn, String aisle) {
		//deletBook
		String id=isbn+aisle;
		System.out.println(id);
		 given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json")
		 .body(Payload.DeleteBook(id))
		 .when().post("/Library/DeleteBook.php")
		 .then().log().all().assertThat().statusCode(200);
		 }
	
  @DataProvider(name="BookData")
  public Object[][] getData() {
	  return new Object[][] {{"cdw","212"},{"fge","321"},{"dsq","211"}};
  }
}
