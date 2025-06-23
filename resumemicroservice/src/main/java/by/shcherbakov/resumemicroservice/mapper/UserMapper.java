package by.shcherbakov.resumemicroservice.mapper;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "resumes", ignore = true)
    User toUser(UserDto dto);
    @Mapping(target = "resumes", ignore = true)
    UserDto toDto(User user);
}
