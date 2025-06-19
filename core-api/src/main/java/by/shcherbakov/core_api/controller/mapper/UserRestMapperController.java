package by.shcherbakov.core_api.controller.mapper;

import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapper/user")
public class UserRestMapperController {

    public UserRestMapperController(@Qualifier("userMapperService") MapperService service) {
        this.service = service;
    }

    private final MapperService service;

    @GetMapping("/to-user")
    public User toUser(@RequestBody UserDto dto) {
        return (User) service.toObject(dto);
    }

    @GetMapping("/to-userdto")
    public UserDto toUserDto(@RequestBody User user) {
        return (UserDto) service.toDto(user);
    }
}
