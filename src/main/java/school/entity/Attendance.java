package school.entity;

import jakarta.persistence.Entity;
import lombok.*;

// bu eng bosh klass outer class

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Attendance extends BaseEntity {

}
