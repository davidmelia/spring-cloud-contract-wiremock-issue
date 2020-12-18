package uk.co.ii.dave;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "uk.co.ii.dave")
@Data
public class DaveProperties {

  private String thirdPartyUrl;

}
