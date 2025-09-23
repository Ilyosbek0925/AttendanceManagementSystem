package school.service.servicePlaneImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.entity.Lesson;
import school.repository.LessonRepository;
import school.service.servicePlane.LessonService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Override
    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(UUID id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();

    }

    @Override
    public Lesson getLessonById(UUID id) {
        return lessonRepository.findById(id).orElse(null);
    }
}
