package by.shcherbakov.apimicroservice.service.impl;

import by.shcherbakov.apimicroservice.config.properties.KafkaTopicsProperties;
import by.shcherbakov.apimicroservice.service.ResumeService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final KafkaTemplate<String,ResumeDto> kafkaTemplate;
    private final KafkaTopicsProperties topicProps;

    @Override
    public String saveResume(ResumeDto dto) {
        try {
            SendResult<String,ResumeDto> result = kafkaTemplate.send(
                            topicProps.getResumeProps().getResumeSaveRequest(),
                            dto
                    ).get();
            log.info("Request was sended in resumemicroservice.saveResume endpoint: {}",result);
            return "Request was sended in resumemicroservice.saveResume endpoint:";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
