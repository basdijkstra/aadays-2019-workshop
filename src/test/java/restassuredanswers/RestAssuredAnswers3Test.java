package restassuredanswers;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredAnswers3Test {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	/*******************************************************
	 * Create a new LocationData object. Use a no-argument constructor:
	 * LocationData locationData = new LocationData();
	 * POST this object to http://localhost:9876/us/68746
	 * Verify that the response HTTP status code is equal to 200
	 * and that the value of the response body element 'result'
	 * equals "OK".
	 ******************************************************/
	
	@Test
	public void postLocationDataObject_checkResponseHttpStatusCode_expect200() {

		LocationData locationData = new LocationData();

		given().
			body(locationData).
		when().
			post("http://localhost:9876/us/68746").
		then().
			assertThat().
			statusCode(200).
		and().
			body("result", equalTo("OK"));
	}

	/*******************************************************
	 * Create another LocationData object. Use a no-argument constructor:
	 * LocationData locationData = new LocationData();
	 * Set the postCode field to 68745 using
	 * locationData.setPostCode("68745");
	 * POST this object to http://localhost:9876/us/68746
	 * Verify that the response HTTP status code is equal to 400 (Bad Request)
	 ******************************************************/

	@Test
	public void postLocationDataObjectWrongZipCode_checkResponseHttpStatusCode_expect400() {

		LocationData locationData = new LocationData();

		locationData.setPostCode("68745");

		given().
			body(locationData).
			when().
			post("http://localhost:9876/us/68746").
			then().
			assertThat().
			statusCode(400);
	}

	/*******************************************************
	 * Send a GET request to http://localhost:9876/pl/80-862
	 * and deserialize the response into an object of type LocationData
	 * Use a JUnit assertEquals() assertion to check that the country
	 * is equal to "Poland". You can get the country from the
	 * LocationData object using the .getCountry() method.
	 ******************************************************/

	@Test
	public void getLocationDataObjectAndDeserialize_checkCountry_expectPoland() {

		LocationData locationData =

		given().
			when().
		get("http://localhost:9876/pl/80-862").
			as(LocationData.class);

		Assert.assertEquals("Poland", locationData.getCountry());
	}
}