package pl.demo.loadtests.application.ports.in;

import pl.demo.loadtests.domain.model.User;

import java.util.Optional;

public interface GetUserUseCase {

    Optional<User> getUser(String userId);

}
