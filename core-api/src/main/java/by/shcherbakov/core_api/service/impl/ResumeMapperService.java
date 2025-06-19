package by.shcherbakov.core_api.service.impl;

import by.shcherbakov.core_api.exception.MapperInstanceofException;
import by.shcherbakov.core_api.mapper.ResumeMapper;
import by.shcherbakov.core_api.service.MapperService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("resumeMapperService")
@AllArgsConstructor
public class ResumeMapperService implements MapperService {

    private final ResumeMapper mapper;

    @Override
    public Object toObject(Object o) {
        ResumeDto dto = null;
        if (o instanceof ResumeDto) {
            dto = (ResumeDto) o;
        } else {
            log.error("Object {} is not type by.shcherbakov.core_domain.dto.ResumeDto",o.getClass());
            throw new MapperInstanceofException("Object is not type by.shcherbakov.core_domain.dto.ResumeDto");
        }
        return mapper.toResume(dto);
    }

    @Override
    public Object toDto(Object o) {
        Resume resume = null;
        if (o instanceof Resume) {
            resume = (Resume) o;
        } else {
            log.error("Object {} is not type by.shcherbakov.core_domain.entity.Resume",o.getClass());
            throw new MapperInstanceofException("Object is not type by.shcherbakov.core_domain.entity.Resume");
        }
        return mapper.toDto(resume);
    }
}
