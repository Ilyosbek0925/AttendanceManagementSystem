package school.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.entity.Lesson;
import school.repository.LessonRepository;
import school.service.LessonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();

    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }
}
