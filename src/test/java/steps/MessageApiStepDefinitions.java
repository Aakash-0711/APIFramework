package steps;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MessageApiStepDefinitions extends BaseClass {

	private File requestBody;
	private int expectedStatusCode;
	

	@Given("I want to send an message through the system")
	public void i_want_to_send_an_message_through_the_system() {
		request = given().log().all();
	}

	@Given("I have provided all required personal details in {string}")
	public void i_have_provided_all_required_personal_details_in(String filePath) {
		requestBody = new File(filePath);
	}

	@When("I submit the message request")
	public void i_submit_the_message_request() {
		response = request.contentType(ContentType.JSON).body(requestBody).post("/");
	}

	@Then("the system should confirm the message has been sent successfully as {int}")
	public void the_system_should_confirm_the_message_has_been_sent_successfully_as(int statusCode) {
		// Write code here that turns the phrase above into concrete actions
		expectedStatusCode = response.statusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
		response.prettyPrint();
	}

	@Then("I should receive a positive confirmation message")
	public void i_should_receive_a_positive_confirmation_message(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> validationData = dataTable.asMap(String.class, String.class);
		validationData.forEach((key, value) -> {
			// Perform validation, e.g., check that the response contains these key-value
			// pairs
			given().contentType(ContentType.JSON).body(requestBody).when().post("/").then()
					.statusCode(expectedStatusCode).body(key, equalTo(value)); // validate key-value pairs
		});
	}

}
