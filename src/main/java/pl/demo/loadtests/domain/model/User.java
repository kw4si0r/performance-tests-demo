package pl.demo.loadtests.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private UserDetails userDetails;
}
