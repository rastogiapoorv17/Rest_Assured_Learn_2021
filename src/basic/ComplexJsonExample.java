package basic;

import files.Payload;
import files.ReusabaleMethods;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		JsonPath js=ReusabaleMethods.rawToJson(Payload.CourseApi());
		
		//No of courses returned by API
		int size=js.getInt("courses.size()");
		System.out.println("No of courses returned by API is "+size);
		
		//Print Purchase Amount
		int pAmount=js.get("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is "+pAmount);
        
        //Print Title of the first course
        System.out.println("Title of the first course is" + js.getString("courses[0].title"));
        
        //Print All course titles and their respective Prices
		for (int i = 0; i < size; i++) {
			System.out.println("Title of the " + i + " course is " + js.getString("courses[" + i + "].title")
					+ " and its price is " + js.getString("courses[" + i + "].price"));

		}
		
		//Print sum of copies sold 
		
		int sum=0; 
		for (int i = 0; i < size; i++) {
		 	sum=sum+js.getInt("courses["+ i +"].copies");
			

		}
		System.out.println("sum of copies sold is " +sum);
		
		//Print no of copies sold by RPA Course
		for (int i = 0; i < size; i++) {
			String courseTitle= js.getString("courses[" + i + "].title");
			if(courseTitle.equalsIgnoreCase("rpa")) {
				String copies=js.getString("courses["+ i +"].copies");
				System.out.println("Number of copies sold by RPA Course is "+ copies);
				break;
			}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		int price_sum=0;
		for(int i=0; i<size; i++)
        {
          
          int price=js.get("courses["+i +"].price");
          int copies=js.get("courses["+i +"].copies");
          int allprice=price*copies;
            
          price_sum=price_sum+allprice;
             }
		System.out.println("Sum of all Course prices is " + price_sum);
		
		if(price_sum==pAmount) {
			System.out.println("Price Matches");
		}
		else
		{
			System.out.println("Price Not Matches");
		}
		Assert.assertEquals(pAmount, price_sum);
		
		
	}

}
