package school.service.impl;

import school.entity.Teacher;

public interface impl {
    Teacher createTeacher(Teacher teacher);

    void deleteTeacher(Long id);

    Teacher getTeacherById(Long id);
}
