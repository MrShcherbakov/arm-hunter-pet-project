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

    @SendTo("#{@kafkaTopicsProperties.userFindResponse}")
    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.userFindRequest}",
            containerFactory = "longContainerFactory"
    )
    public UserDto findUserById(Long id) {
        log.info("Id in findUserById endpoint was received: {}",id);
        return service.findUserById(id);
    }

    @KafkaListener(
            topics = "#{@kafkaTopicsProperties.userSaveRequest}",
            containerFactory = "userDtoContainerFactory"
    )
    public void saveUser(UserDto dto) {
        log.info("UserDto in saveUser endpoint was received: {}",dto);
        service.saveUser(dto);
    }

}
