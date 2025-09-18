package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}
