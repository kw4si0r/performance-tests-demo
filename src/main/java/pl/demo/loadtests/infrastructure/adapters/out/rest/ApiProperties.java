package pl.demo.loadtests.infrastructure.adapters.out.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@ConfigurationProperties("api")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApiProperties {

    private ClientService details;

    @Data
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class EndpointDetails {
        /**
         * Service url
         */
        private String url;

        /**
         * Timeout in milliseconds, default 30s
         */
        @Builder.Default
        private Duration timeout = Duration.of(30L, ChronoUnit.SECONDS);
    }

    @Data
    @NoArgsConstructor
    @Builder
    @AllArgsConstructor
    public static class ClientService {
        private String host;
        private EndpointDetails userDetails;
    }
}
