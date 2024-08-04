import managers.HistoryManager;
import managers.InMemoryHistoryManager;
import models.Task;
import models.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InMemoryHistoryManagerTest {
    private HistoryManager historyManager;
    private Task task;

    @BeforeEach
    void setUp() {
        historyManager = new InMemoryHistoryManager();
        task = new Task("Test Task", "Test Description", 0, TaskStatus.NEW);
        task.setId(1);
    }

    @Test
    void add() {
        historyManager.add(task);
        List<Task> history = historyManager.getHistory();

        assertNotNull(history, "История не должна быть пустой.");
        assertEquals(1, history.size(), "История должна содержать одну задачу.");
        assertEquals(task, history.get(0), "Задача в истории должна совпадать с добавленной задачей.");
    }
}
