package school.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class Lesson extends BaseEntity{
    @Column(nullable = false, length = 100)
    private String subject;

    @Column(nullable = false, length = 50)
    private String room;

    @Column(nullable = false, length = 50)
    private String time;

    @Column(nullable = false, length = 50)
    private String className;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
}
