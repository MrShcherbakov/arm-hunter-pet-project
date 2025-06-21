package by.shcherbakov.resumemicroservice.repository;

import by.shcherbakov.core_domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long> {
}
