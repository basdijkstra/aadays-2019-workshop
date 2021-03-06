package restassuredexercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.*;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredExercises1Test {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	@Test
	public void requestUsZipCode90210_checkResponseCode_expect200() {

		/*******************************************************
		 * Send a GET request to http://localhost:9876/us/90210
		 * and check that the response has HTTP status code 200
		 ******************************************************/
				
		given().
		when().
		then();
	}

	@Test
	public void requestUsZipCode99999_checkResponseCode_expect404() {

		/*******************************************************
		 * Send a GET request to http://localhost:9876/us/99999
		 * and check that the answer has HTTP status code 404
		 ******************************************************/

		given().
		when().
		then();
	}

	@Test
	public void requestUsZipCode90210_checkContentType_expectApplicationJson() {

		/*******************************************************
		 * Send a GET request to http://localhost:9876/us/90210
		 * and check that the response is in JSON format
		 ******************************************************/
				
		given().
		when().
		then();
	}

	@Test
	public void requestUsZipCode90210_checkStateForFirstPlace_expectCalifornia() {

		/***********************************************
		 * Send a GET request to http://localhost:9876/us/90210
		 * and check that the state associated with the first
		 * place in the list returned is equal to 'California'
		 * Use the GPath expression places[0].state to retrieve
		 * the value for the state
		 **********************************************/
				
		given().
		when().
		then();
	}

	@Test
	public void requestDeZipCode24848_checkListOfPlaceNames_expectContainsKropp() {

		/***********************************************
		 * Send a GET request to http://localhost:9876/de/24848
		 * and check that the list of place names returned
		 * contains the value 'Kropp'.
		 * Use the GPath expression places.'place name' to retrieve
		 * the list of place names.
		 **********************************************/
		
		given().
		when().
		then();
	}

	@Test
	public void requestDeZipCode24848_checkListOfPlaceNames_expectDoesNotContainFrankfurt() {

		/***********************************************
		 * Send a GET request to http://localhost:9876/de/24848
		 * and check that the list of place names returned does not
		 * contain the value 'Frankfurt'.
		 * Use the GPath expression places.'place name' to retrieve
		 * the list of place names.
		 **********************************************/
		
		given().
		when().
		then();
	}

	@Test
	public void requestDeZipCode24848_checkNumberOfPlaceNames_expect4() {

		/***********************************************
		 * Send a GET request to http://localhost:9876/de/24848
		 * and check that the list of place names returned is a
		 * collection of size 4.
		 * Use the GPath expression places.'place name' to retrieve
		 * the list of place names.
		 **********************************************/

		given().
		when().
		then();
	}
}