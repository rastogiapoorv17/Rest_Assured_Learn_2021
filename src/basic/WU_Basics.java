package basic;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class WU_Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://wudispatcher-uatci2.westernunion.com";
		
		String response=given().relaxedHTTPSValidation().log().all().queryParam("timestamp", "1622376349082").header("Content-Type","application/json")
		.body("{\r\n" + 
				"  \"device\": {\r\n" + 
				"    \"id\": \"\",\r\n" + 
				"    \"type\": \"WEB\"\r\n" + 
				"  },\r\n" + 
				"  \"channel\": {\r\n" + 
				"    \"name\": \"Western Union\",\r\n" + 
				"    \"type\": \"WEB\",\r\n" + 
				"    \"version\": \"9Z00\",\r\n" + 
				"    \"device_identifier\": \"RESPONSIVE_WEB\",\r\n" + 
				"    \"is_responsive\": \"true\"\r\n" + 
				"  },\r\n" + 
				"  \"external_reference_no\": \"1\",\r\n" + 
				"  \"locale\": {\r\n" + 
				"    \"country_code\": \"de\",\r\n" + 
				"    \"language_code\": \"en\"\r\n" + 
				"  },\r\n" + 
				"  \"security\": {\r\n" + 
				"    \"black_box_data\": {\r\n" + 
				"      \"data\": \"0400CIfeAe15Cx8Nf94lis1ztinPla9Bqhc9Xyx2B+S3GHv4zk88XIRRreGGMWbbP0MYFpHOkICpLx+toj/J9RwnJx5YVcadG796wTpqC7aOF/G7cVE+xxeTH4Zc+cJURcFiYtBUbpa7l0EBgkGiZF1OxvQxv2WDQUOQmcvA1h0yOjywrwf88vayC9C1UJgA1BQZQ4JudHOlf1KSnrbJSNyIsWB9R+WFa6fdxifyrThRovESnjwNVGXSgGQ8InPsuf6/kpMgG84gzO5PMQF00uJew9XqxzJ4y+q4KBbZlok+QrUEKMvH0QZmtL+h8z+Sd1EjljAlWwXHcT+hgN6tJA4p1nA+k9XRlIy/oWrCv4G5CBgjHvyneIxgYgV0ZoJvRVsX5oOKwkEWwEHc6DkgbyoJXz2ghbp6oPhQxA9x3qRKbjObZRutTbZvc93pZ/WuuaUQkm4ZxFADkU6jYmLrUKTmt1etjeiaq6Mfi6gqYs3uxZw/Yyv78QGWljBnxg3zCYy9RS59+NCKS9XeDomViCzxOZx1+u0xFXGux7yacWI+PSJadFnrg+fQHuSyVuz+XbZ3Cj8dCJ1Hz8OixPMqjFULp9I8UWAJoym9T+HoQVdeZcRiqy/Xsv6T2aezazCr+XWGDtPq/jlyS0tO44oNAQPdfLI+vS3zO1UWOjx45x9ZlwMJdmNWP4mnL4jqdQ4rX1XOyAfUMZ5LKFqFl81CC76WZKXakoCa7XCW4IhJrOz08Pzf+x4pw6W9esbGEpq7CoRYvFQ3SxgXyvTx/y4JwLTE4Nxv4KowoTq9m8wIT+uxTF+vHWNkpBX4r0zI+mPNi65X5WFPYlDG9N0Lbh5nOj3u3DXqRCiKCUrsEkMt8z9fxO9pLLGVQUKIYR2wTw53CiWK96FOpPevDWtH2XR0QkfOd02D73n81x6hEMCy0s3hRLn08Th9FlNHDMJBqLj+Tz8r0O/E9ABp/9e7Ass1MT2qnDHnTRQ+uk6KWmQFO6S592/NCwErki320RtrNIES7DL749UONPhzm2+3mFmIfv/wKN+3n0pL0LI3n+SxBYPsXSt0iG7ev0oUuCfOq1vG2COftC6EEsoJWe7xVajijX/olH3AaXYpjQhWtbefWNuGKRCHQeYgB+UaenUkYhaGHY6gnCkm5g/DUsopi0lo9/7KVJav2vSYOUm2VSaircwUTU6bW1C/KJuxEYUnCtRMg7yGDI6/vo3BWRnqdX6zTaTq/Gx0kQCisaQXsvYoLTUezaxFQnLgM2I5gYbmrdYpDURdHb4sD74C/BwLMiie1rP+RqNHAkZiRvYTAKtEdgIORJ7iMml+PG4aGJa3c3jVldoE\",\r\n" + 
				"      \"length\": 1348\r\n" + 
				"    },\r\n" + 
				"    \"client_ip\": \"245024209201\"\r\n" + 
				"  },\r\n" + 
				"  \"bashPath\": \"/de/en\"\r\n" + 
				"}")
		.when().post("wuconnect/rest/api/v1.0/CreateSession")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
     
		
		JsonPath js= new JsonPath(response);
		String session_id=js.get("security.session.id");
		//System.out.println(session_id);
		
	     String mail="derestcheck1232@mailosaur.io";
		//EmailValidation
		String emailresponse=given().relaxedHTTPSValidation().log().all().queryParam("timestamp", "1622376349082").header("Content-Type","application/json")
				.body("{\r\n" + 
						"  \"email\": \""+mail+"\",\r\n" + 
						"  \"security\": {\r\n" + 
						"    \"session\": {\r\n" + 
						"      \"id\": \""+session_id+"\"\r\n" + 
						"    },\r\n" + 
						"    \"client_ip\": \"148064005042\",\r\n" + 
						"    \"version\": 2\r\n" + 
						"  },\r\n" + 
						"  \"bashPath\": \"/de/en\"\r\n" + 
						"}")
				.when().post("wuconnect/rest/api/v1.0/EmailValidation")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//RegisterCustomer
		String registerresponse=given().relaxedHTTPSValidation().log().all().queryParam("timestamp", "1622376349082").header("Content-Type","application/json")
				.body("{\r\n" + 
						"  \"external_reference_no\": \"1\",\r\n" + 
						"  \"security\": {\r\n" + 
						"    \"session\": {\r\n" + 
						"      \"id\": \""+session_id+"\"\r\n" + 
						"    },\r\n" + 
						"    \"client_ip\": \"148064005042\",\r\n" + 
						"    \"version\": \"1\",\r\n" + 
						"    \"black_box_data\": {\r\n" + 
						"      \"data\": \"0400CIfeAe15Cx8Nf94lis1ztsXbhRMC/e3u4KO1B9aa3TU8M/mwQ6zB5zW0GwQ/u+WN+M5PPFyEUa3hhjFm2z9DGBaRzpCAqS8fraI/yfUcJyceWFXGnRu/esE6agu2jhfxu3FRPscXkx+GXPnCVEXBYmLQVG6Wu5dBAYJBomRdTsb0Mb9lg0FDkIQyBqJWXcuvsK8H/PL2sgvQtVCYANQUGUOCbnRzpX9Skp62yUjciLFgfUflhWun3cYn8q04UaLxEp48DVRl0oBkPCJz7Ln+v5KTIBvOIMzuTzEBdNLiXsPV6scyeMvquCgW2ZaJPkK1BCjLx9EGZrS/ofM/kndRI5YwJVsFx3E/oYDerSQOKdZwPpPV0ZSMv9MEAffLb755yWJiLQYfJZ6ClNnrY20wWM2OdxB7nyn3hQG2zhhfF5B6IgHKYTC8k8QPcd6kSm4zvBvS1wqs+/Td6Wf1rrmlEF3eHPuM0JPz5o0AAuzss0XqU1gw6KohgQdhg13I6YIZGqWXrRC9XESM1eyAwSCEbdOjJCyE9AvzCQf7ODMKeW7fPXJE7pCweQbt2F5Q9kqa6dvNHpUoqHe5mZwvTfjFe3omftg0KuaO2wLx3K1GzdiUz9zsPTdL1A1/InDlj2XMuF6OiUfqPLjYdgXmjJkcl86Ub+jneMpqBCjLx9EGZrTBDEGIfSrqljhDYGOJFVPcAfOPjzqyODJKA+IhyeWtUEuHuH9BhO0teGRJquTjspCrgecSo06izVzqeMmBCH/i9cmKrLQxcxA5OE2KkOZe/0jXzk77ILZ/eUsQ7RNrLro1kTKIs1496YkpIh3A707lm2e25SQbo1OQYgL53HoVKaezazCr+XWGHKNCV/CVusXmY1XpDGBtyWF8hRwW7Jsss29L0sFkQPnkjHloApNDPJIEFaG7TsuZF23lTgKl7AiPaqS7dmS/OQAz11sFE541B9tAPWn4oRxXqLz+1vlqUAr9dE2jcfl0IKh8cj1oeYoZWyHUZkZv+34xaHrehirS9Ao9CSzZgtlYjj894FZt/VnZ5Q7TLevE/99i6wW2e7Z3ujmMGneNztm29k0bfK9uwoUEmbuJV4+Ug548yrpSa8O0K2r2UUCrSqs61NqB0zdEN01h2TyddmzigVHFtM5c51W+7h4F0Bl+6I2GuOQuzkPQg0mELpyElU99UoH2xkld+swDdxOjT01lLAsNEnfY7GXuF1Xr5L1ElfrNjL1Ws8J5dTV85D1aCQlHpDZu9J8iLtKhR685GhGad2z/zwLOklzgb5G08cCl5FBAex8tdsd77aFAGnnLiO9fnEGuM2mlQ1o4EpbB0gVz5arDjoJTrqYqyFthzI2bOSABtNYkgIwiZS7Adn1mb2E3wIV4U5jygI9qNzIVWs8yoUp+vkJvHdsV/D7CcgY=\",\r\n" + 
						"      \"length\": 1424\r\n" + 
						"    }\r\n" + 
						"  },\r\n" + 
						"  \"analytics\": {\r\n" + 
						"    \"state\": null,\r\n" + 
						"    \"analytic_event\": {\r\n" + 
						"      \"fields\": {\r\n" + 
						"        \"field\": [\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"registrationPersonalTime\",\r\n" + 
						"            \"value\": \"60\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"registrationSecurityTime\",\r\n" + 
						"            \"value\": \"60\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"registrationTime\",\r\n" + 
						"            \"value\": \"0\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"invalidEmailCount\",\r\n" + 
						"            \"value\": \"3\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"registrationErrorList\",\r\n" + 
						"            \"value\": \"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"infoRegUserName\",\r\n" + 
						"            \"value\": \""+mail+"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"infoSecQ1\",\r\n" + 
						"            \"value\": \"\"\r\n" + 
						"          }\r\n" + 
						"        ]\r\n" + 
						"      }\r\n" + 
						"    }\r\n" + 
						"  },\r\n" + 
						"  \"bashPath\": \"/de/en\",\r\n" + 
						"  \"gateway_customer\": {\r\n" + 
						"    \"email\": \""+mail+"\",\r\n" + 
						"    \"name\": {\r\n" + 
						"      \"last_name\": \"Sharma\",\r\n" + 
						"      \"first_name\": \"Raj\"\r\n" + 
						"    },\r\n" + 
						"    \"identities\": {\r\n" + 
						"      \"identity\": [\r\n" + 
						"        {\r\n" + 
						"          \"data\": \"Welcome123\",\r\n" + 
						"          \"type\": \"PASSWORD\"\r\n" + 
						"        }\r\n" + 
						"      ]\r\n" + 
						"    },\r\n" + 
						"    \"terms_condition_flag\": 0,\r\n" + 
						"    \"account_preferences\": {\r\n" + 
						"      \"direct_mail\": false,\r\n" + 
						"      \"email\": false,\r\n" + 
						"      \"telephone_call\": false,\r\n" + 
						"      \"message\": false,\r\n" + 
						"      \"opt_out_marketing\": false\r\n" + 
						"    }\r\n" + 
						"  },\r\n" + 
						"  \"progressive_registration\": \"true\"\r\n" + 
						"}")
				.when().post("wuconnect/rest/api/v2.0/RegisterCustomer")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//RegisterCustomer
		String signonresponse=given().relaxedHTTPSValidation().log().all().queryParam("timestamp", "1622376349082").header("Content-Type","application/json")
				.body("{\r\n" + 
						"  \"gateway_customer\": {\r\n" + 
						"    \"identities\": {\r\n" + 
						"      \"identity\": [\r\n" + 
						"        {\r\n" + 
						"          \"data\": \""+mail+"\",\r\n" + 
						"          \"type\": \"USERNAME\"\r\n" + 
						"        },\r\n" + 
						"        {\r\n" + 
						"          \"data\": \"Welcome123\",\r\n" + 
						"          \"type\": \"PASSWORD\"\r\n" + 
						"        }\r\n" + 
						"      ]\r\n" + 
						"    }\r\n" + 
						"  },\r\n" + 
						"  \"analytics\": {\r\n" + 
						"    \"state\": null,\r\n" + 
						"    \"analytic_event\": {\r\n" + 
						"      \"fields\": {\r\n" + 
						"        \"field\": [\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"forgotPasswordFlag\",\r\n" + 
						"            \"value\": \"N\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"loginErrorCount\",\r\n" + 
						"            \"value\": \"0\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"siteInfoLoginUser\",\r\n" + 
						"            \"value\": \""+mail+"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"queryString\",\r\n" + 
						"            \"value\": \"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"wuRevision\",\r\n" + 
						"            \"value\": \"Optimus\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"codebase\",\r\n" + 
						"            \"value\": \"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"lightboxFlag\",\r\n" + 
						"            \"value\": \"N\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"siteCatalystVersion\",\r\n" + 
						"            \"value\": \"\"\r\n" + 
						"          },\r\n" + 
						"          {\r\n" + 
						"            \"name\": \"forgotUsernameFlag\",\r\n" + 
						"            \"value\": \"N\"\r\n" + 
						"          }\r\n" + 
						"        ]\r\n" + 
						"      }\r\n" + 
						"    }\r\n" + 
						"  },\r\n" + 
						"  \"device\": {\r\n" + 
						"    \"id\": \"\",\r\n" + 
						"    \"type\": \"WEB\"\r\n" + 
						"  },\r\n" + 
						"  \"external_reference_no\": \"1\",\r\n" + 
						"  \"channel\": {\r\n" + 
						"    \"name\": \"Western Union\",\r\n" + 
						"    \"type\": \"WEB\",\r\n" + 
						"    \"version\": \"9Z00\",\r\n" + 
						"    \"device_identifier\": \"RESPONSIVE_WEB\"\r\n" + 
						"  },\r\n" + 
						"  \"security\": {\r\n" + 
						"    \"session\": {\r\n" + 
						"      \"id\": \""+session_id+"\"\r\n" + 
						"    },\r\n" + 
						"    \"client_ip\": \"148064005042\",\r\n" + 
						"    \"black_box_data\": {\r\n" + 
						"      \"data\": \"0400CIfeAe15Cx8Nf94lis1ztsXbhRMC/e3u4KO1B9aa3TU8M/mwQ6zB5zW0GwQ/u+WN+M5PPFyEUa3hhjFm2z9DGBaRzpCAqS8fraI/yfUcJyceWFXGnRu/esE6agu2jhfxu3FRPscXkx+GXPnCVEXBYmLQVG6Wu5dBAYJBomRdTsb0Mb9lg0FDkIQyBqJWXcuvsK8H/PL2sgvQtVCYANQUGUOCbnRzpX9Skp62yUjciLFgfUflhWun3cYn8q04UaLxEp48DVRl0oBkPCJz7Ln+v5KTIBvOIMzuTzEBdNLiXsPV6scyeMvquCgW2ZaJPkK1BCjLx9EGZrS/ofM/kndRI5YwJVsFx3E/oYDerSQOKdZwPpPV0ZSMv9MEAffLb755yWJiLQYfJZ6ClNnrY20wWM2OdxB7nyn3hQG2zhhfF5B6IgHKYTC8k8QPcd6kSm4zvBvS1wqs+/Td6Wf1rrmlEF3eHPuM0JPz5o0AAuzss0XqU1gw6KohgQdhg13I6YIZGqWXrRC9XESM1eyAwSCEbdOjJCyE9AvzCQf7ODMKeW7fPXJE7pCweQbt2F5Q9kqa6dvNHpUoqHe5mZwvTfjFe3omftg0KuaO2wLx3K1GzdiUz9zsPTdL1A1/InDlj2XMuF6OiUfqPLjYdgXmjJkcl86Ub+jneMpqBCjLx9EGZrTBDEGIfSrqljhDYGOJFVPcAfOPjzqyODJKA+IhyeWtUEuHuH9BhO0teGRJquTjspCrgecSo06izVzqeMmBCH/i9cmKrLQxcxA5OE2KkOZe/0jXzk77ILZ/eUsQ7RNrLro1kTKIs1496YkpIh3A707lm2e25SQbo1OQYgL53HoVKaezazCr+XWGHKNCV/CVusXmY1XpDGBtyWF8hRwW7Jsss29L0sFkQPnkjHloApNDPJIEFaG7TsuZF23lTgKl7AiPaqS7dmS/OQAz11sFE541B9tAPWn4oRxXqLz+1vlqUAr9dE2jcfl0IKh8cj1oeYoZWyHUZkZv+34xaHrehirS9Ao9CSzZgtlYjj894FZt/VnZ5Q7TLevE/99i6wW2e7Z3ujmMGneNztm29k0bfK9uwoUEmbuJV4+Ug548yrpSa8O0K2r2UUCrSqs61NqB0zdEN01h2TyddmzigVHFtM5c51W+7h4F0Bl+6I2GuOQuzkPQg0mELpyElU99UoH2xkld+swDdxOjT01lLAsNEnfY7GXuF1Xr5L1ElfrNjL1Ws8J5dTV85D1aCQlHpDZu9J8iLtKhR685GhGad2z/zwLOklzgb5G08cCl5FBAex8tdsd77aFAGnnLiO9fnEGuM2mlQ1o4EpbB0gVz5arDjoJTrqYqyFthzI2bOSABtNYkgIwiZS7Adn1mb2E3wIV4U5jygI9qNzIVWs8yoUp+vkJvHdsV/D7CcgY=\",\r\n" + 
						"      \"length\": 1424\r\n" + 
						"    },\r\n" + 
						"    \"device_details\": \"{\\\"V\\\":\\\"2.0\\\",\\\"T\\\":\\\"webbr\\\",\\\"FP\\\":\\\"7ff6f95b9cfe54abe1aaf06436537a39\\\",\\\"user_agent\\\":\\\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36\\\",\\\"language\\\":\\\"en-US\\\",\\\"color_depth\\\":24,\\\"resolution\\\":[1366,768],\\\"available_resolution\\\":[1366,728],\\\"timezone_offset\\\":-330,\\\"session_storage\\\":1,\\\"local_storage\\\":1,\\\"indexed_db\\\":1,\\\"open_database\\\":1,\\\"cpu_class\\\":\\\"unknown\\\",\\\"navigator_platform\\\":\\\"Win32\\\",\\\"do_not_track\\\":\\\"1\\\",\\\"regular_plugins\\\":\\\"d790a30ff81ef07e6b46d35fa27d94aa\\\",\\\"canvas\\\":\\\"9318b9d88902a7b86c5d0b16cf27f2a3\\\",\\\"webgl\\\":\\\"0998e08551cd9807e679e8c0ede4e436\\\",\\\"adblock\\\":false,\\\"has_lied_languages\\\":false,\\\"has_lied_resolution\\\":false,\\\"has_lied_os\\\":false,\\\"has_lied_browser\\\":false,\\\"touch_support\\\":[0,false,false],\\\"js_fonts\\\":\\\"054c7cecb6ce780166c7014461e6d768\\\"}\",\r\n" + 
						"    \"httpHeader\": \"access-control-allow-headers: accept, origin, content-type, man, messagetype, soapaction, x-requested-with, wucountrycode, wulanguagecode, wutoken, x-wu-correlation-id, x-wu-transaction-id, useridentity, user-identity\\r\\naccess-control-allow-methods: get, post, head, put, options\\r\\naccess-control-allow-origin: *\\r\\ncache-control: no-cache,no-store\\r\\nconnection: keep-alive\\r\\ncontent-encoding: gzip\\r\\ncontent-length: 30022\\r\\ncontent-type: text/html; charset=utf-8\\r\\ndate: mon, 31 may 2021 09:40:38 gmt\\r\\nexpires: thu, 01 jan 1970 00:00:00 gmt\\r\\nkeep-alive: timeout=5, max=95\\r\\npragma: no-cache\\r\\nserver: apache\\r\\nstrict-transport-security: max-age=31536000; includesubdomains;\\r\\nvary: accept-encoding\\r\\nx-content-type-options: nosniff\\r\\nx-frame-options: sameorigin\\r\\nx-xss-protection: 1; mode=block\\r\\n\"\r\n" + 
						"  },\r\n" + 
						"  \"bashPath\": \"/de/en\"\r\n" + 
						"}")
				.when().post("wuconnect/rest/api/v2.0/CustomerSignOn")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		/*//GetLimit
		given().relaxedHTTPSValidation().log().all().queryParam("timestamp", "1622291968475").header("Content-Type","application/json")
				.body("{\r\n" + 
						"  \"external_reference_no\": \"1\",\r\n" + 
						"  \"channel\": {\r\n" + 
						"    \"name\": \"Western Union\",\r\n" + 
						"    \"type\": \"WEB\",\r\n" + 
						"    \"version\": \"9Z00\",\r\n" + 
						"    \"device_identifier\": \"RESPONSIVE_WEB\"\r\n" + 
						"  },\r\n" + 
						"  \"security\": {\r\n" + 
						"    \"session\": {\r\n" + 
						"      \"id\": \""+session_id+"\"\r\n" + 
						"    },\r\n" + 
						"    \"client_ip\": \"148064005027\",\r\n" + 
						"    \"version\": \"2\"\r\n" + 
						"  },\r\n" + 
						"  \"payment_details\": {\r\n" + 
						"    \"origination\": {\r\n" + 
						"      \"currency_iso_code\": \"EUR\",\r\n" + 
						"      \"country_iso_code\": \"DE\"\r\n" + 
						"    },\r\n" + 
						"    \"destination\": {\r\n" + 
						"      \"currency_iso_code\": \"TRY\",\r\n" + 
						"      \"country_iso_code\": \"TR\"\r\n" + 
						"    }\r\n" + 
						"  }\r\n" + 
						"}")
				.when().post("wudgtsrvs/mobiliser/rest/channel/GwpGetLimits")
				.then().log().all().assertThat().statusCode(200);*/
	}

}
