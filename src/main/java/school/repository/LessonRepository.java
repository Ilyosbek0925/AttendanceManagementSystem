package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.Lesson;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
    List<Lesson> findAllByTeacher_Id(UUID teacherId);
}
