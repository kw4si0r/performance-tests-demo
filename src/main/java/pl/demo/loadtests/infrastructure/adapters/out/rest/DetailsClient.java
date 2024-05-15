package pl.demo.loadtests.infrastructure.adapters.out.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.demo.loadtests.application.ports.out.GetUserDetailsPort;
import pl.demo.loadtests.domain.model.UserDetails;

import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class DetailsClient implements GetUserDetailsPort {

    private final RestTemplate restTemplate;
    private final ApiProperties apiProperties;

    @Override
    public Optional<UserDetails> getUserDetails(String userId) {
        log.debug("Calling {}", apiProperties.getDetails().getUserDetails().getUrl());
        ResponseEntity<pl.demo.loadtests.api.generated.details.model.DetailsDto> detailsEntity = restTemplate.getForEntity(apiProperties.getDetails().getUserDetails().getUrl() + "{userId}",
                pl.demo.loadtests.api.generated.details.model.DetailsDto.class, Map.of("userId", userId));
        if (detailsEntity.getStatusCode().is2xxSuccessful()) {
            log.debug("Got response with status {}", detailsEntity.getStatusCode());
            return Optional.of(detailsEntity)
                    .map(HttpEntity::getBody)
                    .map(x -> UserDetails.builder().description(x.getDescription()).info(x.getInfo()).build());
        }
        return Optional.empty();
    }
}
