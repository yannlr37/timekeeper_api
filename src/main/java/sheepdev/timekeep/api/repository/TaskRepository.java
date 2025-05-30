package sheepdev.timekeep.api.repository;

import sheepdev.timekeep.api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Tu peux ajouter des méthodes plus tard comme findByName

    Optional<Task> findByUuid(String uuid);
}
