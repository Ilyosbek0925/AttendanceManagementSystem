package school.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClassEntity  extends BaseEntity  {

    private UUID uuid;
    private String name;
    private String teacher;
    private int studentCount;

}
