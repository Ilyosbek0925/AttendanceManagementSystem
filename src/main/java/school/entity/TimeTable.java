package school.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class TimeTable extends BaseEntity{
}
