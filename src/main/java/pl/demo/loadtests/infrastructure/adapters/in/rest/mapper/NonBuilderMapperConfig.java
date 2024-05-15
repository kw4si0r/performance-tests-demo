package pl.demo.loadtests.infrastructure.adapters.in.rest.mapper;

import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;

@MapperConfig(builder = @Builder(disableBuilder = true))
public class NonBuilderMapperConfig {
}
