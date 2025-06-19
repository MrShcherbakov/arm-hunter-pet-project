package by.shcherbakov.usermicroservice.service.impl;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.usermicroservice.config.properties.KafkaTopicsProperties;
import by.shcherbakov.usermicroservice.repository.UserRepository;
import by.shcherbakov.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final KafkaTopicsProperties topicProps;
    private final UserRepository repository;

    @Override
    public UserDto findUserById(Long id) {
        log.info("User was received from bd successfully: ");
        return new UserDto();
    }
}
