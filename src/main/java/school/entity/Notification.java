package school.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Notification extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity sender;
    @OneToMany(cascade = CascadeType.ALL)
    private List<UserEntity> recipient;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

}
