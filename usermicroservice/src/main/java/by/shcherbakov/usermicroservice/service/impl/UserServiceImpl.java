package by.shcherbakov.usermicroservice.service.impl;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.core_domain.entity.User;
import by.shcherbakov.usermicroservice.config.properties.ApiUrlsProperties;
import by.shcherbakov.usermicroservice.repository.UserRepository;
import by.shcherbakov.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final MapperServiceUtilImpl mapperService;
    private final ApiUrlsProperties urlProps;
    private final UserRepository repository;

    @Override
    public UserDto findUserById(Long id) {
        Optional<User> optional = repository.findById(id);
        User user = checkNullPointerException(optional);
        return mapperService.requestToMap(
               urlProps.getToUserdtoUrl(),
               user,
               UserDto.class
        );
    }

    @Override
    public void saveUser(UserDto dto) {
        User user = mapperService.requestToMap(
                urlProps.getToUserUrl(),
                dto,
                User.class
        );
        User userBd = repository.save(user);
        log.info("User was saved in UserServiceImpl.saveUser: {}",userBd);
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

}
