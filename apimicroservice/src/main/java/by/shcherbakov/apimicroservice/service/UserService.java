package by.shcherbakov.apimicroservice.service;


import by.shcherbakov.apimicroservice.domain.dto.UserDto;

public interface UserService {
    UserDto findUserById(Long id);
}
