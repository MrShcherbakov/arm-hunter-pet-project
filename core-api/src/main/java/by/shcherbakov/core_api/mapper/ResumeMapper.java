package by.shcherbakov.core_api.mapper;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResumeMapper {
    ResumeDto toDto(Resume resume);
    Resume toResume(ResumeDto dto);
}
