package by.shcherbakov.usermicroservice.service;


import by.shcherbakov.core_domain.dto.UserDto;

public interface UserService {
    UserDto findUserById(Long id);
}
