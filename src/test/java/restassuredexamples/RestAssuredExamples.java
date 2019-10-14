package restassuredexamples;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class RestAssuredExamples {

    @Test
    public void validateCountryForZipCode() {

        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().
            body("country", equalTo("United States"));
    }

    @Test
    public void checkResponseHeaders() {

        given().
        when().
            get("http://api.zippopotam.us/us/90210").
        then().
            assertThat().
            statusCode(200).
        and().
            contentType(ContentType.JSON);
    }

    @Test
    public void useQueryParameter() {

        given().
            queryParam("text","testcase").
        when().
            get("http://md5.jsontest.com").
        then().
            assertThat().
            body("md5", equalTo("7489a25fc99976f06fecb807991c61cf"));
    }

    @Test
    public void usePathParameter() {

        given().
            pathParam("countryCode","us").
            pathParam("zipCode", "90210").
        when().
            get("http://api.zippopotam.us/{countryCode}/{zipCode}").
        then().
            assertThat().
            body("country", equalTo("United States"));
    }

    @DataProvider
    public static Object[][] zipCodeData() {
        return new Object[][] {
            {"us","90210","United States"},
            {"ca","B2A","Canada"}
        };
    }

    @Test
    @UseDataProvider("zipCodeData")
    public void checkCountryForCountryCodeAndZipCode
        (String countryCode, String zipCode, String expectedCountry) {

        given().
            pathParam("countryCode",countryCode).
            pathParam("zipCode", zipCode).
        when().
            get("http://api.zippopotam.us/{countryCode}/{zipCode}").
        then().
            assertThat().
            body("country", equalTo(expectedCountry));
    }

    @Test
    public void serializeAddressToJson() {

        Address myAddress = new Address("My street", 1, 1234, "Amsterdam");

        given().
            body(myAddress).
        when().
            post("http://localhost:9876/address").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void deserializeJsonToAddress() {

        Address myAddress =

        given().
        when().
            get("http://localhost:9876/address").
            as(Address.class);

        Assert.assertEquals("Amsterdam", myAddress.getCity());
    }
}
