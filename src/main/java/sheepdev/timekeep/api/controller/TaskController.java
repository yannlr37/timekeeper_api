package sheepdev.timekeep.api.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sheepdev.timekeep.api.dto.TaskDto;
import sheepdev.timekeep.api.dto.TimelineDto;
import sheepdev.timekeep.api.mapper.TaskMapper;
import sheepdev.timekeep.api.mapper.TimelineMapper;
import sheepdev.timekeep.api.model.Task;
import sheepdev.timekeep.api.model.Timeline;
import sheepdev.timekeep.api.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;
import sheepdev.timekeep.api.repository.TimelineRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final TimelineRepository timelineRepository;

    public TaskController(
            TaskRepository taskRepository,
            TimelineRepository timelineRepository
    ) {
        this.taskRepository = taskRepository;
        this.timelineRepository = timelineRepository;
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        List<TaskDto> taskDtoList = new ArrayList<>();
        List<Task> tasks = taskRepository.findAll();
        for (Task task : tasks) {
            TaskDto dto = TaskMapper.toDto(task);
            taskDtoList.add(dto);
        }
        return taskDtoList;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto) {
        Task task = TaskMapper.fromDto(taskDto);
        return taskRepository.save(task);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Task> getTaskByUuid(@PathVariable String uuid) {
        return taskRepository.findByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{uuid}/timelines")
    public ResponseEntity<List<Timeline>> getTimelinesForTask(@PathVariable String uuid) {
        Optional<Task> task = taskRepository.findByUuid(uuid);

        return task.map(t -> ResponseEntity.ok(t.getTimelines()))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{uuid}/timelines")
    public ResponseEntity<?> addTimeline(@PathVariable String uuid, @RequestBody TimelineDto dto) {
        Task task = taskRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (dto.getElapsedTime() == null || dto.getElapsedTime() <= 0) {
            Map<String, String> message = Map.of("message", "Could not create a timeline with no valid duration");
            return ResponseEntity.ok(message);
        } else {
            Timeline timeline = TimelineMapper.fromDto(dto);
            timeline.setTask(task);
            timelineRepository.save(timeline);
            return ResponseEntity.status(HttpStatus.CREATED).body(dto);
        }
    }
}
