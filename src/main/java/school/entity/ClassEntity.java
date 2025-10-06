package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
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
    private int studentCount;
    @OneToMany(mappedBy = "", fetch = FetchType.LAZY)
    List<Student> students;

}
