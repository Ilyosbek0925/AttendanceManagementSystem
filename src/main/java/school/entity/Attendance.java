package school.entity;

import jakarta.persistence.*;
import lombok.*;
import school.enums.Reason;
import school.enums.ReasonType;

@Entity

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Attendance extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Reason reason;

    @Enumerated(EnumType.STRING)
    private ReasonType reasonType;

    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

}
