package school.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import school.enums.Roles;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthDate;
    private Roles role;


}
