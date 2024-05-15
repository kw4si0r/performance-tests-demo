package pl.demo.loadtests.infrastructure.adapters.in.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRsp {

    @JsonProperty("name1")
    private String name;

    @JsonProperty("surname1")
    private String surname;

    private String information;
}
