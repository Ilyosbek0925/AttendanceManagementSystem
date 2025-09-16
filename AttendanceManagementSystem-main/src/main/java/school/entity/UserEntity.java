package school.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.management.relation.Role;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class UserEntity extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Notification>notifications;

    @OneToMany(mappedBy = "studentUser")
    private List<Attendance>attendances;
}
