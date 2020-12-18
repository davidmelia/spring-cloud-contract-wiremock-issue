package uk.co.ii.dave.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import uk.co.ii.dave.DaveProperties;

@RestController
@RequestMapping("/api/1")
@AllArgsConstructor
public class CashController {

  private final DaveProperties properties;
  private final WebClient wc = WebClient.builder().build();

  @GetMapping(value = "/cash", produces = APPLICATION_JSON_VALUE)
  public Mono<Map> getAccount() {
    System.out.println("*******");
    System.out.println(properties.getThirdPartyUrl() + "/cash");
    System.out.println("*******");
    return wc.get().uri(properties.getThirdPartyUrl() + "/cash").retrieve().bodyToMono(Map.class);
  }
}
