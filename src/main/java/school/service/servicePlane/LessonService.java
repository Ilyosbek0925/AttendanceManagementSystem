package school.service.servicePlane;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.entity.Lesson;

import java.util.List;
import java.util.UUID;


public interface LessonService {
    Lesson createLesson(Lesson lesson);
    void deleteLesson(UUID id);
    List<Lesson> getAllLessons();
    Lesson getLessonById(UUID id);
}
