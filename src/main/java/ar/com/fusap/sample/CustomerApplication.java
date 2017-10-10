package ar.com.fusap.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EntityScan(basePackages = {"ar.com.fusap.sample"})
@ComponentScan(basePackages = {"ar.com.fusap.sample"})
@EnableAutoConfiguration
public class CustomerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
