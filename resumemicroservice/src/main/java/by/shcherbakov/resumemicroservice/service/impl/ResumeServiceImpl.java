package by.shcherbakov.resumemicroservice.service.impl;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import by.shcherbakov.resumemicroservice.config.properties.ApiUrlsProperties;
import by.shcherbakov.resumemicroservice.repository.ResumeRepository;
import by.shcherbakov.resumemicroservice.service.ResumeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final MapperUtilServiceImpl mapperService;
    private final ResumeRepository repository;
    private final ApiUrlsProperties urlProps;

    @Override
    public void saveResume(ResumeDto dto) {
        Resume resume = mapperService.requestToMap(
                urlProps.getToResumeUrl(),
                dto,
                Resume.class
        );
        Resume entity = repository.save(resume);
        log.info("Resume was saved in ResumeServiceImpl.saveResume: {}",entity);
    }
}
