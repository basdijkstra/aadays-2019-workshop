package wiremockexamples;

import com.github.tomakehurst.wiremock.http.Fault;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockExamples {

    public void helloWorld() {

        stubFor(
            get(
                urlEqualTo("/helloworld")
            )
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withStatus(200)
                        .withBody("Hello world!")));
    }

    public void setupStubURLMatching() {

        stubFor(get(urlEqualTo("/urlmatching"))
            .willReturn(aResponse()
                .withBody("URL matching")
            ));
    }

    public void setupStubHeaderMatching() {

        stubFor(get(urlEqualTo("/headermatching"))
            .withHeader("Content-Type", containing("application/json"))
            .withHeader("DoesntExist", absent())
            .willReturn(aResponse()
                .withBody("Header matching")
            ));
    }


    public void setupStubReturningErrorCode() {

        stubFor(get(urlEqualTo("/errorcode"))
            .willReturn(aResponse()
                .withStatus(500)
                .withStatusMessage("Status message goes here")
            ));
    }

    public void setupStubFixedDelay() {

        stubFor(get(urlEqualTo("/fixeddelay"))
            .willReturn(aResponse()
                .withFixedDelay(2000)
            ));
    }

    public void setupStubBadResponse() {

        stubFor(get(urlEqualTo("/badresponse"))
            .willReturn(aResponse()
                .withFault(Fault.MALFORMED_RESPONSE_CHUNK)
            ));
    }
}
