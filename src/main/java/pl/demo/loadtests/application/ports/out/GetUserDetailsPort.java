package pl.demo.loadtests.application.ports.out;

import pl.demo.loadtests.domain.model.UserDetails;

import java.util.Optional;

public interface GetUserDetailsPort {

    Optional<UserDetails> getUserDetails(String userId);
}
