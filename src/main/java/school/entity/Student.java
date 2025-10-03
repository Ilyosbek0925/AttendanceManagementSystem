package school.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student extends UserEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    ClassEntity classEntity;
}
