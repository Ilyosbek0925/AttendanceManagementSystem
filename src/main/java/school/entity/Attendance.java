package school.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Attendance extends BaseEntity {

}
