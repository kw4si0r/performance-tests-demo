package pl.demo.loadtests.infrastructure.adapters.in.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        UserController.class,
        GlobalExceptionHandler.class
})
@ComponentScan({
        "pl.demo.loadtests.infrastructure.adapters.in.rest.mapper"
})
public class RestAdapterTestConfig {
}
