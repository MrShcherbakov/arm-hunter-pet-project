package by.shcherbakov.apimicroservice.service.impl;

import by.shcherbakov.apimicroservice.config.properties.topic.ResumeKafkaTopicsProperties;
import by.shcherbakov.apimicroservice.exception.HttpRestStatusCodeException;
import by.shcherbakov.apimicroservice.service.ResumeService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final KafkaTemplate<String,ResumeDto> kafkaTemplate;
    private final ResumeKafkaTopicsProperties topicProps;
    private final RestTemplate restTemplate;
    private final UserServiceImpl userService;

    @Override
    public String saveResume(ResumeDto dto) {
        addResumeToUser(
                dto,
                userService.findUserById(dto.getUser().getId())
        );
        try {
            SendResult<String,ResumeDto> result = kafkaTemplate.send(
                            topicProps.getResumeSaveRequest(),
                            dto
                    ).get();
            log.info("Request for the saving the resume was sent in resumemicroservice: {}"
                    ,result.getRecordMetadata());
            return "Request for the saving the resume was sent";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteResumeById(Long id) {
        ResumeDto dto = new ResumeDto();
        dto.setId(id);
        try {
            SendResult<String,ResumeDto> result =
                    kafkaTemplate.send(
                            topicProps.getResumeDeleteRequest(),
                            dto
                    ).get();
            log.info("Request for the deleting the resume by id was sent in resumemicroservice: {}",
                    result.getRecordMetadata());
            return "Request for the deleting the resume by id was sent";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private void addResumeToUser(ResumeDto resumeDto,UserDto userDto) {
        if (userDto == null) {
            log.error("UserDto is null in ResumeServiceImpl.addResumeToUser");
            throw new NullPointerException("UserDto is null in ResumeServiceImpl.addResumeToUser");
        }
        String saveUserUrl = "http://apimicroservice:8080/user/save";
        List<ResumeDto> resumes = userDto.getResumes();
        resumes.add(resumeDto);
        userDto.setResumes(resumes);
        restTemplate.postForLocation(
                saveUserUrl,
                userDto
        );
        log.info("Request for the saving the user was posted to {}",saveUserUrl);
    }
}
