package pl.demo.loadtests.infrastructure.adapters.out.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@Tag("integration")
@Sql({
        "/sql/ddl.sql",
        "/sql/data.sql"
})
@Import(PersistenceAdapterConfig.class)
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("positive path for getting user ")
    @Test
    void getPositivePathForExistingUser() {
        var user = userRepository.getUser("user1@pm.me");
        assertNotNull(user);
        assertTrue(user.isPresent());
        assertEquals("nowak", user.get().getSurname());
    }
}
