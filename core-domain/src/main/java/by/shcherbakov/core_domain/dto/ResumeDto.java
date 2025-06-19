package by.shcherbakov.core_domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
    private Long id;
    private String description;
    private UserDto user;
}
