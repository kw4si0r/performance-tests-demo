package pl.demo.loadtests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = {"pl.demo.loadtests"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
})
@SpringBootApplication
public class LoadtestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadtestsApplication.class, args);
    }

}
