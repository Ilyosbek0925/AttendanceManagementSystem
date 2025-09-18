package school.service;

import school.entity.Lesson;

import java.util.List;

public interface LessonService {
    Lesson createLesson(Lesson lesson);
    void deleteLesson(Long id);
    List<Lesson> getAllLessons();
    Lesson getLessonById(Long id);
}
