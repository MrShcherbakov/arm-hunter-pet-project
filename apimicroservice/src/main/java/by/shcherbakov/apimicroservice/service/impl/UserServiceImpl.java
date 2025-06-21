package by.shcherbakov.apimicroservice.service.impl;

import by.shcherbakov.apimicroservice.config.properties.topic.UserKafkaTopicsProperties;
import by.shcherbakov.apimicroservice.service.UserService;
import by.shcherbakov.core_domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final KafkaTemplate<String,UserDto> kafkaTemplate;
    private final ReplyingKafkaTemplate<String,Long, UserDto> replyingKafkaTemplate;
    private final UserKafkaTopicsProperties topicProps;

    @Override
    public UserDto findUserById(Long id) {

        ProducerRecord<String,Long> request =
                new ProducerRecord<>(topicProps.getUserFindRequest(),id);
        request.headers().add(new RecordHeader(
                KafkaHeaders.REPLY_TOPIC,
                topicProps.getUserFindResponse().getBytes()
        ));

        RequestReplyFuture<String,Long,UserDto> future =
                replyingKafkaTemplate.sendAndReceive(request);
        log.info("ProducerRecord in findUserById was sended successfully: {}",request);

        ConsumerRecord<String,UserDto> response;
        try {
            response = future.get();
            log.info("Response in findUserById was received successfully: {}",response.value());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.value();
    }

    @Override
    public String saveUser(UserDto dto) {
        try {
            SendResult<String,UserDto> result = kafkaTemplate.send(
                topicProps.getUserSaveRequest(),dto
            ).get();
            log.info("Request was sended in usermicroservice.saveUser: {}",result.getProducerRecord());
            return "Request was sended in usermicroservice.saveUser endpoint";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
