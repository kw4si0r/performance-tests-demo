package pl.demo.loadtests.infrastructure.adapters.in.rest;


import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.demo.loadtests.application.ports.in.GetUserUseCase;
import pl.demo.loadtests.infrastructure.adapters.in.rest.mapper.UserMapper;
import pl.demo.loadtests.infrastructure.adapters.in.rest.model.UserRsp;
import pl.demo.loadtests.infrastructure.adapters.metrics.MetricsConfig;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final GetUserUseCase getUserUseCase;
    private final UserMapper userMapper;

    @GetMapping(
            path = ""
            , produces = "application/vnd.demo.v2+json"
    )
    @Timed(value = MetricsConfig.PORTS_IN_METRICS, percentiles = {0.5, 0.95})
    public ResponseEntity<UserRsp> getDetailsForUser(@RequestParam(name = "user-id") String userId) {
        return getUserUseCase.getUser(userId)
                .map(userMapper::maptoUserRsp)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.unprocessableEntity().build());
    }

}
