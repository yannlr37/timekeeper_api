package sheepdev.timekeep.api.mapper;

import sheepdev.timekeep.api.dto.TimelineDto;
import sheepdev.timekeep.api.model.Timeline;

public class TimelineMapper {

    /**
     * Create a new task from an object coming from the outside world
     *
     * @param dto TaskDto
     * @return Task
     */
    public static Timeline fromDto(TimelineDto dto) {
        Timeline timeline = new Timeline();
        timeline.setStartedAt(dto.getStartedAt());
        timeline.setElapsedTime(dto.getElapsedTime());
        return timeline;
    }
}
