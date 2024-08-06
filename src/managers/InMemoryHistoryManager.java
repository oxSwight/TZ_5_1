package managers;

import models.Task;

import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final LinkedList<Task> history = new LinkedList<>();
    private static final int HISTORY_LIMIT = 16;

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }
        if (!history.contains(task)) {
            history.add(task);
        } else {
            history.remove(task);
            history.add(task);
            // Если задача уже присутствует в коллекции, сначала она удаляется,
            // а затем снова добавляется. Это делается для того,
            // чтобы переместить её в конец списка
        }
        if (history.size() > HISTORY_LIMIT) {
            history.removeFirst();
        }
    }

    @Override
    public List<Task> getHistory() {
        return new LinkedList<>(history);
    }
}
