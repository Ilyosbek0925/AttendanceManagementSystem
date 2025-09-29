package school.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification extends UserEntity{

    @Column(name="sender_name",nullable = false)
    private String senderName;
    @Column(name = "receiver_name",nullable = false)
    private String recieverName;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "message",nullable = false, columnDefinition = "TEXT")
    private String message;
    @Column(name = "is_read",nullable = false)
    private boolean isRead;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
    
}
