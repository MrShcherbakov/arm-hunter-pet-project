package by.shcherbakov.usermicroservice.mapper;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = ResumeMapper.class)
public interface UserMapper {
    UserDto toDto(User user);
    User toUser(UserDto dto);
}
