package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Student extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;


}
