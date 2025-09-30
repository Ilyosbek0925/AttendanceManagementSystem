package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.AdminEntity;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<AdminEntity, UUID> {
}
