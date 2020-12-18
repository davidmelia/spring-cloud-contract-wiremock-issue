package uk.co.ii.dave.contract;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import io.restassured.RestAssured;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.ii.dave.DaveApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DaveApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"contract-test2"})
@AutoConfigureWireMock(port = 0)
public class Dave2ContractBase {


  @LocalServerPort
  private int port;

  @BeforeEach
  public void setup() throws IOException {
    RestAssured.baseURI = "http://localhost:" + port;
    stubFor(get(urlMatching("/test/cash")).willReturn(aResponse().withHeader("Content-Type", "application/json").withStatus(200).withBody("{\"USD\":\"3.45\"}")));
  }

}
