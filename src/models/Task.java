package models;

public class Task {
    private int id;
    private final String name;
    private final String description;
    private final int duration;
    private TaskStatus status;

    public Task(String name, String description, int duration, TaskStatus status) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", status=" + status +
                '}';
    }
}
