package by.shcherbakov.core_api.service.impl;

import by.shcherbakov.core_api.exception.MapperInstanceofException;
import by.shcherbakov.core_api.mapper.UserMapper;
import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userMapperService")
@AllArgsConstructor
public class UserMapperService implements MapperService {

    private final UserMapper mapper;

    @Override
    public Object toObject(Object o) {
        UserDto dto = null;
        if (o instanceof UserDto) {
            dto = (UserDto) o;
        } else {
            log.error("Object {} is not type by.shcherbakov.core_domain.dto.UserDto",o.getClass());
            throw new MapperInstanceofException("Object is not type by.shcherbakov.core_domain.dto.UserDto");
        }
        return mapper.toUser(dto);
    }

    @Override
    public Object toDto(Object o) {
        User user = null;
        if (o instanceof User) {
            user = (User) o;
        } else {
            log.error("Object {} is not type by.shcherbakov.core_domain.entity.User",o.getClass());
            throw new MapperInstanceofException("Object is not type by.shcherbakov.core_domain.entity.User");
        }
        return mapper.toDto(user);
    }
}
