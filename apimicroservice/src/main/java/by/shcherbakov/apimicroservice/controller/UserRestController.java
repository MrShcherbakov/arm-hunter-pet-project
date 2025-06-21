package by.shcherbakov.apimicroservice.controller;

import by.shcherbakov.apimicroservice.service.UserService;
import by.shcherbakov.core_domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final UserService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        log.info("Id was received in findUserById endpoint: {}",id);
        return ResponseEntity.ok(service.findUserById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDto dto) {
        log.info("UserDto was received in saveUser endpoint: {}",dto);
        return ResponseEntity.ok(service.saveUser(dto));
    }

}
