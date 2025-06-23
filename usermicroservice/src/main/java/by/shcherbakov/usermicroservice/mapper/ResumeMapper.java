package by.shcherbakov.usermicroservice.mapper;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResumeMapper {
    @Mapping(target = "user",ignore = true)
    Resume toResume(ResumeDto dto);
    @Mapping(target = "user",ignore = true)
    ResumeDto toDto(Resume resume);
}
