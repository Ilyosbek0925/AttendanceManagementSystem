package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.Teacher;

import java.util.Optional;
import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {
    Optional<Teacher> findByMail(String email);
}
