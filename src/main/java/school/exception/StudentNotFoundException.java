package school.exception;

import java.util.UUID;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(UUID uuid){
        super("Student not found with id "+uuid);
    }
}
