package pl.demo.loadtests.infrastructure.adapters.in.rest.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.demo.loadtests.domain.model.User;
import pl.demo.loadtests.domain.model.UserDetails;
import pl.demo.loadtests.infrastructure.adapters.in.rest.model.UserRsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Spy
    @InjectMocks
    UserMapper underTest = Mappers.getMapper(UserMapper.class);

    @DisplayName("check mappings from User to UserRsp")
    @Test
    void checkMappingToUserRsp() {
        User source = User.builder().name("jan").surname("nowak").userDetails(UserDetails.builder().info("qwerty").build()).build();

        UserRsp target = underTest.maptoUserRsp(source);

        assertEquals("jan", target.getName());
        assertEquals("nowak", target.getSurname());
        assertEquals("qwerty", target.getInformation());

    }
}
