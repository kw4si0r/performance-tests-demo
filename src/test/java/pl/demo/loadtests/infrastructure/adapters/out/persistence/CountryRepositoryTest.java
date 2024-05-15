package pl.demo.loadtests.infrastructure.adapters.out.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(properties = {
        "spring.jpa.hibernate.ddl-auto=none"
})
@Tag("integration")
@Sql({
        "/sql/ddl.sql",
        "/sql/data.sql"
})
@Import(PersistenceAdapterConfig.class)
class CountryRepositoryTest {

    @Autowired
    CountryRepository repository;

    @DisplayName("positive path for getting country ")
    @Test
    void getPositivePath() {
        var country = repository.getCountry(1L);
        assertNotNull(country);
        assertTrue(country.isPresent());
        assertNotNull(country.get().getName());

        assertNotNull(country.get().getCities());
        assertFalse(country.get().getCities().isEmpty());
    }
}
