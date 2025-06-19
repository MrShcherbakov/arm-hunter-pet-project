package by.shcherbakov.usermicroservice.service;

import by.shcherbakov.usermicroservice.domain.dto.UserDto;

public interface UserService {
    UserDto findUserById(Long id);
}
