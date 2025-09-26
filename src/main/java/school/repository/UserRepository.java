package school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByMail(String mail);
    Optional<UserEntity>findByMailAndCode(String mail, Integer code);
    boolean existsByMail(String mail);

    List<UserEntity> searchByMail(String mail);

    List<UserEntity> getByMail(String mail);
}
