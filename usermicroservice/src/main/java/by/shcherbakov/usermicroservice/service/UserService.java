package by.shcherbakov.usermicroservice.service;


import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    UserDto findUserById(Long id);
    User checkNullPointerException(Optional<User> user);
}
