package by.shcherbakov.core_api.controller.mapper;

import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapper/resume")
public class ResumeRestMapperController {

    public ResumeRestMapperController(@Qualifier("resumeMapperService") MapperService service) {
        this.service = service;
    }

    private final MapperService service;

    @GetMapping("/to-resume")
    public Resume toResume(ResumeDto dto) {
        return (Resume) service.toObject(dto);
    }

    @GetMapping("/to-resumedto")
    public ResumeDto toDto(Resume resume) {
        return (ResumeDto) service.toDto(resume);
    }

}
