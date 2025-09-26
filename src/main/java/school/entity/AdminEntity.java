package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter

@Table(name = "admins")
public class AdminEntity extends UserEntity {
}
