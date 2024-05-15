package pl.demo.loadtests.application.ports.out;

import pl.demo.loadtests.domain.model.Country;

import java.util.Optional;

public interface GetCountryPort {

    Optional<Country> getCountry(Long countryId);
}
