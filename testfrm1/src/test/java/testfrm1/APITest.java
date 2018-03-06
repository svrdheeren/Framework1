package testfrm1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APITest {
	@Test
	public void GetTwitter(){
		String ConsumerKey = "nVc97cBmexiS3g01aNCJhW8kE";
		String ConsumerSecret = "9VOe9bfiEonh3MNEqaRxToq4w3kF55FzirJlHClB8FjhFM7WMD";
		String Token = "970161084903645184-rDT18BuoZRvdIUu50pgHFaCDIJlCYUc";
		String TokenSecret = "63Ay9TWMOzopAtYPjK3OdaYNendMKewADHugTSiK8N7Yn";
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
		Response Rep = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
			queryParam("count", "1").
		when().
			get("/home_timeline.json").
		then().
			assertThat().statusCode(200).
			and().contentType(ContentType.JSON).
		extract().response();
		
		System.out.println("Response: " + Rep.asString());
		JsonPath JP = new JsonPath(Rep.asString());
		ArrayList<String> text = JP.get("text");
		System.out.println("text: " + text.get(0) +  " size: " + text.size());
/*
		String Req2 = "{"+
				"\"place_id\": \""+placeID+"\""+
				"}";
		Response Rep2 = given().
			queryParam("key","AIzaSyCePU5DxqlIWuPQoayOiG5wU-0UO5jwvh0").
			body(Req2).
		when().
			post("/maps/api/place/delete/json").
		then().
			assertThat().statusCode(200).
			and().contentType(ContentType.JSON).
			body("status",equalTo("OK")).
		extract().response();
		System.out.println("Response: " + Rep2.asString());
		JsonPath JP2 = new JsonPath(Rep.asString());
		System.out.println("STATUS:" + JP.get("status"));
		*/
	}

	private String text(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
