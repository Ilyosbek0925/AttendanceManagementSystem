package school.service;

import school.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);
    void deleteTeacher(Long id);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
}
