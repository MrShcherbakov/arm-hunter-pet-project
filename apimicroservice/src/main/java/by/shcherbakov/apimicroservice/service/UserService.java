package by.shcherbakov.apimicroservice.service;


import by.shcherbakov.core_domain.dto.UserDto;

public interface UserService {
    UserDto findUserById(Long id);
    String saveUser(UserDto dto);
}
