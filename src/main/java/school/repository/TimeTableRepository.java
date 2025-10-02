package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.TimeTable;

import java.util.UUID;

public interface TimeTableRepository extends JpaRepository<TimeTable, UUID> {

}
