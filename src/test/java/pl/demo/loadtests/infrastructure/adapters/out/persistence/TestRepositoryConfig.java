package pl.demo.loadtests.infrastructure.adapters.out.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceAdapterConfig.class)
class TestRepositoryConfig {

}
