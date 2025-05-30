package sheepdev.timekeep.api.dto;

public class TaskDto {

    private String name;
    private String uuid;

    public TaskDto() {
    }

    public TaskDto(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
