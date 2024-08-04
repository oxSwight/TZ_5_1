package models;

public class Subtask extends Task {
    private final int epicId;

    public Subtask(String name, String description, int duration, TaskStatus status, int epicId) {
        super(name, description, duration, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", duration=" + getDuration() +
                ", status=" + getStatus() +
                ", epicId=" + epicId +
                '}';
    }
}
