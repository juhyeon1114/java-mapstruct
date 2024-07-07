package study.javamapstruct.mapper;


import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.javamapstruct.domain.Address;
import study.javamapstruct.domain.User;
import study.javamapstruct.domain.UserDto;

@Slf4j
class UserMapperTest {

    @Test
    void 맵핑_테스트() throws Exception {
        UserMapper userMapper = UserMapper.INSTANCE;

        // 샘플 값
        String email = "test@test.com";
        String name = "Test name";
        int age = 20;
        String location = "서울";
        String detail = "강남";

        // DTO 생성
        UserDto dto = new UserDto();
        dto.setEmail(email);
        dto.setName(name);
        dto.setAge(age);

        // DTO -> Entity 검증
        User entity = userMapper.toEntity(dto);
        assertThat(entity.getEmail()).isEqualTo(email);
        assertThat(entity.getName()).isEqualTo(name);
        assertThat(entity.getAge()).isEqualTo(age);

        // DTO + Address -> Entity 검증
        Address address = new Address(location, detail);
        User entityWithAddress = userMapper.toEntityWithAddress(dto, address);
        assertThat(entityWithAddress.getAddress().getLocation()).isEqualTo(location);
        assertThat(entityWithAddress.getAddress().getDetail()).isEqualTo(detail);
    }

}