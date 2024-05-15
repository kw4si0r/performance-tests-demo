package pl.demo.loadtests.infrastructure.adapters.in.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.demo.loadtests.domain.model.User;
import pl.demo.loadtests.infrastructure.adapters.in.rest.model.UserRsp;

@Mapper(componentModel = "spring", uses = {CityMapper.class}, config = NonBuilderMapperConfig.class)
public abstract class UserMapper {

    @Mapping(source = "user.surname", target = "surname")
    @Mapping(source = "user.userDetails.info", target = "information")
    public abstract UserRsp maptoUserRsp(User user);
}
