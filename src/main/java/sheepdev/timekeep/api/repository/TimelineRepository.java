package sheepdev.timekeep.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sheepdev.timekeep.api.model.Timeline;

public interface TimelineRepository extends JpaRepository<Timeline, Long> {
    // Tu peux ajouter des méthodes plus tard comme findByName
}