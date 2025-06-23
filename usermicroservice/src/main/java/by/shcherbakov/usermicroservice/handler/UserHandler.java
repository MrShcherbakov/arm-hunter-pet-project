package by.shcherbakov.usermicroservice.handler;

import by.shcherbakov.core_domain.dto.UserDto;
import by.shcherbakov.usermicroservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserHandler {

    private final UserService service;

    @SendTo("user.find.response")
    @KafkaListener(
            topics = "user.find.request",
            containerFactory = "longContainerFactory"
    )
    public UserDto findUserById(Long id) {
        log.info("Id in findUserById endpoint was received: {}",id);
        return service.findUserById(id);
    }

    @KafkaListener(
            topics = "user.save.request",
            containerFactory = "userDtoContainerFactory"
    )
    public void saveUser(UserDto dto) {
        log.info("UserDto in saveUser endpoint was received: {}",dto);
        service.saveUser(dto);
    }

}
