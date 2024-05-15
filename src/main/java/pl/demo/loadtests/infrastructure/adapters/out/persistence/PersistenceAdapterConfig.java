package pl.demo.loadtests.infrastructure.adapters.out.persistence;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableJpaRepositories
@ComponentScan(
        basePackages = "pl.demo.loadtests.infrastructure.adapters.out.persistence"
)
@EntityScan("pl.demo.loadtests.infrastructure.adapters.out.persistence.entity")
public class PersistenceAdapterConfig {


}
