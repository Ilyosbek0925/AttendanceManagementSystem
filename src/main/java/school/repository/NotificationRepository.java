package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.entity.Notification;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByReceiver_Id(UUID receiverId);
    List<Notification> findBySender_Id(UUID senderId);
    List<Notification> findByReceiver_IdAndIsReadFalse(UUID receiverId);
}
