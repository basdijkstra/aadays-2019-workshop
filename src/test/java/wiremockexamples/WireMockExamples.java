package wiremockexamples;

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
}
