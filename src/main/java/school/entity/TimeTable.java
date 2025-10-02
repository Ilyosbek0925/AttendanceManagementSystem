package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Table(name = "time_table")
public class TimeTable extends BaseEntity{

    private int lessonNumber;
    private LocalTime startTime;
    private LocalTime endTime;

}
