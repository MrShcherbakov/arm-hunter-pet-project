package by.shcherbakov.resumemicroservice.handler;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.resumemicroservice.service.ResumeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ResumeHandler {

    private final ResumeService service;

    @KafkaListener(
            topics = "#{@resumeTopicsProperties.resumeSaveRequest}",
            containerFactory = "resumeDtoContainerFactory"
    )
    public void saveResume(ResumeDto dto) {
        log.info("ResumeDto was received in saveResume endpoint: {}",dto);
        service.saveResume(dto);
    }

    @KafkaListener(
            topics = "#{resumeTopicsProperties.resumeDeleteRequest}",
            containerFactory = "resumeDtoContainerFactory"
    )
    public void deleteResumeById(ResumeDto dto) {
        log.info("ResumeDto was received in deleteResumeById endpoint: {}",dto);
        service.deleteResumeById(dto);
    }

}
