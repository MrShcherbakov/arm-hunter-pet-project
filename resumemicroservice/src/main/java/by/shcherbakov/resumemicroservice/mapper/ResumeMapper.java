package by.shcherbakov.resumemicroservice.mapper;

import by.shcherbakov.core_domain.dto.ResumeDto;
import by.shcherbakov.core_domain.entity.Resume;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface ResumeMapper {
    Resume toResume(ResumeDto dto);
    ResumeDto toDto(Resume resume);
}
