package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class SetUp {
	
	// Method to be executed before each test
	@Before
	public void setUp() throws FileNotFoundException, IOException{ 
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		RestAssured.baseURI = prop.getProperty("base.uri");
		
		
	}
	
	@After
	public void tearDown(Scenario sc){ 
		// Print the name of the scenario
		System.out.println(sc.getName());
	}
}
