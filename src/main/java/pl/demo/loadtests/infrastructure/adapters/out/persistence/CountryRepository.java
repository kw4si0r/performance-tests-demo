package pl.demo.loadtests.infrastructure.adapters.out.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.demo.loadtests.application.ports.out.GetCountryPort;
import pl.demo.loadtests.domain.model.City;
import pl.demo.loadtests.domain.model.Country;
import pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.CountryEntity;
import pl.demo.loadtests.infrastructure.adapters.out.persistence.entity.CountryEntity_;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * for joining tests
 */
@RequiredArgsConstructor
@Slf4j
@Repository
public class CountryRepository implements GetCountryPort {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Country> getCountry(Long countryId) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(CountryEntity.class);

        var country = query.from(CountryEntity.class);
//        Path<CountryId> countryIdPath = country.get(CountryEntity_.id);

        var city = country.join(CountryEntity_.cities, JoinType.LEFT);

        List<Predicate> predicates = new LinkedList<>();
        predicates.add(
                criteriaBuilder.equal(country.get(CountryEntity_.id), countryId)
        );

        query.select(country)
                .where(predicates.toArray(Predicate[]::new));

        var result = entityManager.createQuery(query).getSingleResult();
        return Optional.of(Country.builder()
                .name(result.getName())
                .cities(result.getCities().stream().map(it -> City.builder().name(it.getName()).build()).toList())
                .build());
    }

}
