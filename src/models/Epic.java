package models;

public class Epic extends Task {
    public Epic(String name, String description, int duration, TaskStatus status) {
        super(name, description, duration, status);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", duration=" + getDuration() +
                ", status=" + getStatus() +
                '}';
    }
}
