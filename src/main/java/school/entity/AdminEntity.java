package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import school.enums.Role;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "admins")
public class AdminEntity extends UserEntity {


}
