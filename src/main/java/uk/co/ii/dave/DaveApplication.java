package uk.co.ii.dave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DaveProperties.class)
public class DaveApplication {



  public static void main(String[] args) {
    SpringApplication.run(DaveApplication.class, args);
  }

}
