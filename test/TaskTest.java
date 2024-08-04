import models.Task;
import models.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest {

    @Test
    void testTasksEquality() {
        Task task1 = new Task("Task", "Description", 0, TaskStatus.NEW);
        task1.setId(1);
        Task task2 = new Task("Task", "Description", 0, TaskStatus.NEW);
        task2.setId(1);

        assertEquals(task1, task2, "Задачи с одинаковым id должны быть равны.");
    }
}
