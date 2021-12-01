package files;

public class Payload {
	
	public static String AddPlace() {
		return "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
				+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Rahul Shetty Academy\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"43, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";

	}
	
		
	public static String UpdatePlace(String placeId, String newAddress) {
		// TODO Auto-generated method stub
		return "{\r\n" + "\"place_id\":\"" + placeId + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "";
	}

	public static String CourseApi() {
		return "{\r\n" + "\"dashboard\": {\r\n" + "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n" + "},\r\n" + "\"courses\": [\r\n" + "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n" + "\"price\": 50,\r\n" + "\"copies\": 6\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"Cypress\",\r\n" + "\"price\": 40,\r\n" + "\"copies\": 4\r\n" + "},\r\n"
				+ "{\r\n" + "\"title\": \"RPA\",\r\n" + "\"price\": 45,\r\n" + "\"copies\": 10\r\n" + "}\r\n" + "]\r\n"
				+ "}\r\n" + "";
	}

	public static String AddBook(String isbn, String aisle) {
		return "{\r\n" + "\r\n" + "\"name\":\"Learn Appium Automation with Java\",\r\n" + "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+ aisle+"\",\r\n" + "\"author\":\"John foe\"\r\n" + "}\r\n" + " \r\n" + "";
	}
	public static String DeleteBook(String id) {
		return "{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+id+"\"\r\n" + 
				" \r\n" + 
				"} \r\n" + 
		"";
	}

	public static String CreateSession(String username, String password) {
		return "\r\n" + "{ \"username\": \""+username+"\", \"password\": \""+password+"\" }";
	}
	
	public static String CreateIssue() {
		return "{\r\n" + "    \"fields\": {\r\n" + "        \"project\": {\r\n" + "            \"key\": \"JDP\"\r\n"
				+ "        },\r\n" + "        \"summary\": \"My Testing Bug\",\r\n"
				+ "        \"description\": \"Apoorv--My Testing Bug\",\r\n" + "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n" + "        }\r\n" + "    }\r\n" + "}";
	}

	public static String AddComment() {
		return "{\r\n" + "    \"body\": \"Adding Comment.\",\r\n" + "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n" + "        \"value\": \"Administrators\"\r\n" + "    }\r\n" + "}";

	}

	public static String UpdateComment() {
		return "{\r\n" + "    \"body\": \"Updating Comment\",\r\n" + "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n" + "        \"value\": \"Administrators\"\r\n" + "    }\r\n" + "}";

	}
	}


