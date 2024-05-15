package pl.demo.loadtests.infrastructure.adapters.in.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

//@Builder //problems with @AfterMapping
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityRsp {

    @JsonProperty("city_name")
    private String name;

}
