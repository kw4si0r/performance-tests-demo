package pl.demo.loadtests.domain.service;

import lombok.RequiredArgsConstructor;
import pl.demo.loadtests.application.ports.in.GetUserUseCase;
import pl.demo.loadtests.application.ports.out.GetUserDetailsPort;
import pl.demo.loadtests.application.ports.out.GetUserPort;
import pl.demo.loadtests.domain.model.User;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService implements GetUserUseCase {

    private final GetUserPort getUserPort;
    private final GetUserDetailsPort getUserDetailsPort;

    @Override
    public Optional<User> getUser(String userId) {
        return getUserPort.getUser(userId).map(user -> {
            getUserDetailsPort.getUserDetails(userId).ifPresent(user::setUserDetails);
            return user;
        });
    }
}
