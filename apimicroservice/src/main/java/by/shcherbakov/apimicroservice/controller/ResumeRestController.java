package by.shcherbakov.apimicroservice.controller;

import by.shcherbakov.apimicroservice.service.ResumeService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/resume")
public class ResumeRestController {

    private final ResumeService service;

    @PostMapping("/save")
    public ResponseEntity<String> saveResume(@RequestBody ResumeDto dto) {
        log.info("ResumeDto was received in saveResume endpoint: {}",dto);
        return ResponseEntity.ok(service.saveResume(dto));
    }
}
