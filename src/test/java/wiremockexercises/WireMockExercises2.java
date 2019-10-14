package wiremockexercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockExercises2 {

    private RequestSpecification requestSpec;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9876);

    @Before
    public void createRequestSpec() {

        requestSpec = new RequestSpecBuilder().
            setBaseUri("http://localhost").
            setPort(9876).
            build();
    }

    public void setupStubExercise201() {

        /************************************************
         * Create a stub that will respond to all GET
         * requests to /servicedown
         * with HTTP status code 503 and a status message
         * equal to 'Service unavailable'
         ************************************************/

    }

    public void setupStubExercise202() {

        /************************************************
         * Create a stub that will respond to a GET request
         * to /slow with request header 'speed' with value 'slow'.
         * Respond with status code 200, but only after a
         * fixed delay of 3000 milliseconds.
         ************************************************/

    }

    @Test
    public void testExercise201Java() {

        /***
         * Use this test to test the Java implementation of exercise 201
         */

        setupStubExercise201();

        given().
            spec(requestSpec).
        when().
            get("/servicedown").
        then().
            assertThat().
            statusCode(503).
        and().
            statusLine(org.hamcrest.Matchers.containsString("Service unavailable"));
    }

    @Test
    public void testExercise201Json() {

        /***
         * Use this test to test the JSON implementation of exercise 201
         */

        given().
            spec(requestSpec).
        when().
            get("/servicedown").
        then().
            assertThat().
            statusCode(503).
        and().
            statusLine(org.hamcrest.Matchers.containsString("Service unavailable"));
    }

    @Test
    public void testExercise202Java() {

        /***
         * Use this test to test the Java implementation of exercise 202
         */

        setupStubExercise202();

        given().
            spec(requestSpec).
        and().
            header("speed","slow").
        when().
            get("/slow").
        then().
            assertThat().
            statusCode(200).
        and().
            time(org.hamcrest.Matchers.greaterThan(3000L));
    }

    @Test
    public void testExercise202Json() {

        /***
         * Use this test to test the JSON implementation of exercise 202
         */

        given().
            spec(requestSpec).
        and().
            header("speed","slow").
        when().
            get("/slow").
        then().
            assertThat().
            statusCode(200).
        and().
            time(org.hamcrest.Matchers.greaterThan(3000L));
    }
}
