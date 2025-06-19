package by.shcherbakov.core_domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;

    @Column(name = "resumes")
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Resume> resumes;
}
