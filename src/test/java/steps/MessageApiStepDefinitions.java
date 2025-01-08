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
	private String messageId;
	

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
		
		expectedStatusCode = response.statusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
		response.prettyPrint();
		messageId = response.jsonPath().getString("id");
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
	
	@Given("I have entered an email address in an incorrect format in {string}")
	public void i_have_entered_an_email_address_in_an_incorrect_format_in(String filePath) {
		requestBody = new File(filePath);
	}

	@Then("the system should reject the submission as {int}")
	public void the_system_should_reject_the_submission_as(int statusCode) {
		expectedStatusCode = response.statusCode();
		Assert.assertEquals(statusCode, expectedStatusCode);
		response.prettyPrint();
	}
	
	@Given("I want to view the particular message created")
	public void i_want_to_view_the_particular_message_created() {
		response = request.contentType(ContentType.JSON).get("/"+ messageId);
	}
	
	@Given("I want to update the existing message by changing the email address")
	public void i_want_to_update_the_existing_message_by_changing_the_email_address() {
		response = request.contentType(ContentType.JSON).put("/"+ messageId+"/read");
	}
	
	@Given("I want to delete the existing date")
	public void i_want_to_delete_the_existing_date() {
		response = request.contentType(ContentType.JSON).delete("/"+ messageId);
	}


}
