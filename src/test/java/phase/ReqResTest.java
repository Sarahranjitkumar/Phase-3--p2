package phase;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReqResTest {
	@Test
	public void GetAll_Employee() {
		
			RestAssured.given()
					.baseUri("https://reqres.in/api/users")
					.when()
					.get()
					.then()
					.log()
					.all()
					.statusCode(200);
		
	}
	
	@Test
	public void GetSingle_Employee () {
		
		RestAssured.given()
		.baseUri("https://reqres.in/api/users")
		.when()
		.get("/3")
		.then()
		.log()
		.all()
		.statusCode(200);
		
	}
	
	public Logger logger = Logger.getLogger("PostRequest");
	@Test
    public void Post_Employee() {
	

	{
	BasicConfigurator.configure();
	
	logger.info("started the post call using BDD");
	HashMap<String,String> obj = new HashMap<String,String>();
	
	
	obj.put( "name", "morpheus");
	obj.put("job", "leader");
	
	RestAssured.given()
				.baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(obj)
				.when()
				.post()
				.then()
				.log()
				.all();
		
	logger.info("post call ended with---");
}

}
}