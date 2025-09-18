package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
