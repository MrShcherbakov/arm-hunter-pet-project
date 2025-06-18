package by.shcherbakov.apimicroservice.controller;

import by.shcherbakov.apimicroservice.domain.dto.UserDto;
import by.shcherbakov.apimicroservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    private final UserService service;

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findUserById(id));
    }
}
