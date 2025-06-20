package by.shcherbakov.usermicroservice.service.impl;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import by.shcherbakov.usermicroservice.config.properties.ApiUrlsProperties;
import by.shcherbakov.usermicroservice.exception.HttpRestStatusCodeException;
import by.shcherbakov.usermicroservice.repository.UserRepository;
import by.shcherbakov.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ApiUrlsProperties urlProps;
    private final UserRepository repository;
    private final RestTemplate restTemplate;

    @Override
    public UserDto findUserById(Long id) {
        Optional<User> optional = repository.findById(id);
        User user = checkNullPointerException(optional);
        return toDto(user);
    }

    @Override
    public User checkNullPointerException(Optional<User> user) {
        if (user.isPresent()) {
            log.info("User was retrieved from bd successfully: {}",user.get());
            return user.get();
        } else {
            log.error("User was retrieved from bd with null");
            throw new NullPointerException("User was retrieved from bd with null");
        }
    }

    //Only for rest getMapping
    @Override
    public Object checkRestStatusCodeException(ResponseEntity<?> entity) {
        if (entity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            log.info("RestTemplate received entity {} with status code 200",entity.getBody());
            return entity.getBody();
        } else {
            log.error("RestTemplate received entity {} with another status code {}",entity,entity.getStatusCode());
            throw new HttpRestStatusCodeException("RestTemplate received entity with another status code "
                    + entity.getStatusCode());
        }
    }

    @Override
    public User toUser(UserDto dto) {
        ResponseEntity<User> entity =
                restTemplate.postForEntity(
                        urlProps.getToUserUrl(),
                        dto,
                        User.class
                );
        log.info("User was received successfully from /to-user: {}",entity.getBody());
        return (User) checkRestStatusCodeException(entity);
    }

    @Override
    public UserDto toDto(User user) {
        ResponseEntity<UserDto> entity =
                restTemplate.postForEntity(
                        urlProps.getToUserdtoUrl(),
                        user,
                        UserDto.class
                );
        log.info("UserDto was received successfully from /to-userdto: {}",entity);
        return (UserDto) checkRestStatusCodeException(entity);
    }


}
