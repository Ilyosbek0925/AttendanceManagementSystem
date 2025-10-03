package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import school.enums.Period;

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
    private Period period;
    private LocalTime startTime;
    private LocalTime endTime;

}
