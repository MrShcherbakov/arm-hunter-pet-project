package by.shcherbakov.apimicroservice.controller;

import by.shcherbakov.apimicroservice.service.ResumeService;
import by.shcherbakov.core_domain.dto.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteResumeById(@PathVariable Long id) {
        log.info("Id was received in deleteResumeById endpoint: {}",id);
        return ResponseEntity.ok(service.deleteResumeById(id));
    }
}
