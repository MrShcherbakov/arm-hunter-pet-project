package by.shcherbakov.core_domain.dto;

import by.shcherbakov.core_domain.entity.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private List<Resume> resumes;
}
