package pl.demo.loadtests.domain;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.demo.loadtests.application.ports.in.GetUserUseCase;
import pl.demo.loadtests.application.ports.out.GetUserDetailsPort;
import pl.demo.loadtests.application.ports.out.GetUserPort;
import pl.demo.loadtests.domain.service.UserService;
import pl.demo.loadtests.infrastructure.adapters.out.rest.ApiProperties;
import pl.demo.loadtests.infrastructure.adapters.out.rest.DetailsClient;

@Configuration
public class DomainConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public GetUserDetailsPort getUserDetailsPort(RestTemplate restTemplate, ApiProperties apiProperties) {
        return new DetailsClient(restTemplate, apiProperties);
    }

    @Bean
    public GetUserUseCase getUserUseCase(GetUserPort userPort, GetUserDetailsPort getUserDetailsPort) {
        return new UserService(userPort, getUserDetailsPort);
    }

}
