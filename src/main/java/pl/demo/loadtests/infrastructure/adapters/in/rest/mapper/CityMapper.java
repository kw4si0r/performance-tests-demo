package pl.demo.loadtests.infrastructure.adapters.in.rest.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.demo.loadtests.domain.model.City;
import pl.demo.loadtests.infrastructure.adapters.in.rest.model.CityRsp;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityRsp maptoRsp(City source);

    @AfterMapping
    default void afterRspMapping(City source, @MappingTarget CityRsp target) {
        target.setName(target.getName().toUpperCase());
    }
}
