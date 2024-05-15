package pl.demo.loadtests.infrastructure.adapters.out.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiPropertiesTest {
    @Autowired
    ApiProperties underTest;

    @DisplayName("check if properties are loaded properly from yml file")
    @Test
    void checkPropertiesLoading() {
        ApiProperties.ClientService details = underTest.getDetails();

        assertThat(details).isNotNull();
        assertThat(details.getHost()).isNotNull().isEqualTo("http://localhost:8091");
        assertThat(details.getUserDetails()).isNotNull().isEqualTo(
                ApiProperties.EndpointDetails.builder()
                        .url("http://localhost:8091/user/details/")
                        .timeout(Duration.of(13L, ChronoUnit.SECONDS))
                        .build()
        );
    }
}