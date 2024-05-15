package pl.demo.loadtests.application.ports.out;

import pl.demo.loadtests.domain.model.User;

import java.util.Optional;

public interface GetUserPort {

    Optional<User> getUser(String userId);
}
