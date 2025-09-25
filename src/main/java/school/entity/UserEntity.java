package school.entity;

import jakarta.persistence.*;
import lombok.*;
import school.enums.Role;



@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String last_name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false,unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;


}
