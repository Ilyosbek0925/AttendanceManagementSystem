package school.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Student extends BaseEntity{
}
