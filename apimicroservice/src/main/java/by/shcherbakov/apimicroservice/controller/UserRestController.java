package by.shcherbakov.apimicroservice.controller;

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

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable Long id) {
        return
    }
}
