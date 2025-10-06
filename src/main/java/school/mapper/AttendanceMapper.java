package school.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import school.dto.requestDto.AttendanceRequestDto;
import school.dto.responseDto.AttendanceResponseDto;
import school.entity.Attendance;
import school.repository.StudentRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class AttendanceMapper {

    private final StudentRepository repository;

    private final StudentMapper studentMapper;


    public Attendance toAttendance(AttendanceRequestDto dto) {
        Attendance attendance = new Attendance();
        attendance.setReason(dto.getReason());
        attendance.setComment(dto.getComment());
        attendance.setStudent(repository.findById(dto.getStudentId()).orElseThrow(() -> {
            log.error("student not found with the id {}", dto.getStudentId());
            return new EntityNotFoundException("student not found with the id " + dto.getStudentId());
        }));

        return attendance;
    }


    public AttendanceResponseDto toAttendanceResponseDto(Attendance attendance) {
        return AttendanceResponseDto.builder()
                .comment(attendance.getComment())
                .reason(attendance.getReason())
                .reasonType(attendance.getReasonType())
                .studentResponseDto(studentMapper.toStudentResponseDto(attendance.getStudent()))
                .build();
    }

}
