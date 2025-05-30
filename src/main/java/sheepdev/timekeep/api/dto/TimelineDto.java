package sheepdev.timekeep.api.dto;

import java.time.LocalDateTime;

public class TimelineDto {
    private LocalDateTime startedAt;
    private Long elapsedTime;

    public TimelineDto() {
    }

    public TimelineDto(LocalDateTime startedAt, Long elapsedTime) {
        this.startedAt = startedAt;
        this.elapsedTime = elapsedTime;
    }

    public LocalDateTime getStartedAt() {
        return this.startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public Long getElapsedTime() {
        return this.elapsedTime;
    }

    public void setElapsedTime(Long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
