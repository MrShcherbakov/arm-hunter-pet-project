package by.shcherbakov.apimicroservice.service;

import by.shcherbakov.core_domain.dto.ResumeDto;

public interface ResumeService {
    String saveResume(ResumeDto dto);
    String deleteResumeById(Long id);
}
