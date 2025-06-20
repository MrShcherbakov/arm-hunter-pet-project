package by.shcherbakov.core_api.controller.mapper;

import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/mapper")
public class UserRestMapperController {

    public UserRestMapperController(@Qualifier("userMapperService") MapperService service) {
        this.service = service;
    }

    private final MapperService service;

    @PostMapping("/to-user")
    public User toUser(@RequestBody UserDto dto) {
        log.info("Request toUser was received: {}",dto);
        User user = (User) service.toObject(dto);
        log.info("Mapping userDto to user was finished successfully: {}",user);
        return user;
    }

    @PostMapping("/to-userdto")
    public UserDto toUserDto(@RequestBody User user) {
        log.info("Request toUserDto was received: {}",user);
        UserDto dto = (UserDto) service.toDto(user);
        log.info("Mapping user to userDto was finished successfully: {}",dto);
        return dto;
    }
}
