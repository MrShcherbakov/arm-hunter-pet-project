package by.shcherbakov.resumemicroservice.service;

import by.shcherbakov.core_domain.dto.ResumeDto;

public interface ResumeService {
    void saveResume(ResumeDto dto);
}
