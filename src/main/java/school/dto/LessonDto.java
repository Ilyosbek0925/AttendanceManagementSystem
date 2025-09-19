package school.dto;

import lombok.Data;

@Data
public class LessonDto {
    private Long id;
    private String subject;
    private String room;
    private String time;
    private String className;
    private Long teacherId;
}
