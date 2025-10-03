package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.Attendance;

import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
}
