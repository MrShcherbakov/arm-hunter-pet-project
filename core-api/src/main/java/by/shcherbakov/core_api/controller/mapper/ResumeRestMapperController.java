package by.shcherbakov.core_api.controller.mapper;

import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mapper/resume")
public class ResumeRestMapperController {

    public ResumeRestMapperController(@Qualifier("resumeMapperService") MapperService service) {
        this.service = service;
    }

    private final MapperService service;

    @GetMapping("/to-resume")
    public Resume toResume(ResumeDto dto) {
        log.info("Request toResume was received: {}",dto);
        Resume resume = (Resume) service.toObject(dto);
        log.info("Mapping resumeDto to resume was finished successfully: {}",dto);
        return resume;
    }

    @GetMapping("/to-resumedto")
    public ResumeDto toDto(Resume resume) {
        log.info("Request toResumeDto was received: {}",resume);
        ResumeDto dto = (ResumeDto) service.toDto(resume);
        log.info("Mapping resume to resumeDto was finished successfully: {}",resume);
        return dto;
    }

}
