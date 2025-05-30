package sheepdev.timekeep.api.mapper;

import sheepdev.timekeep.api.dto.TaskDto;
import sheepdev.timekeep.api.model.Task;

import java.util.UUID;

public class TaskMapper {

    /**
     * Create a new task from an object coming from the outside world
     *
     * @param dto TaskDto
     * @return Task
     */
    public static Task fromDto(TaskDto dto) {
        Task task = new Task();
        task.setUuid(UUID.randomUUID().toString());
        task.setName(dto.getName());
        return task;
    }

    /**
     * Expose a task DTO to the outside world
     *
     * @param task Task
     * @return TaskDto
     */
    public static TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setUuid(task.getUuid());
        dto.setName(task.getName());
        return dto;
    }
}
