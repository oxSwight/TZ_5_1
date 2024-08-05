import managers.Managers;
import managers.TaskManager;
import models.Epic;
import models.Subtask;
import models.Task;
import models.TaskStatus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание менеджера задач
        TaskManager taskManager = Managers.getDefaultTaskManager();

        // Создание и добавление задач
        Task task1 = new Task("Task 1", "Description of Task 1", 60, TaskStatus.NEW);
        int task1Id = taskManager.addNewTask(task1);
        System.out.println("Added task: " + task1);

        Task task2 = new Task("Task 2", "Description of Task 2", 30, TaskStatus.NEW);
        int task2Id = taskManager.addNewTask(task2);
        System.out.println("Added task: " + task2);

        // Создание и добавление эпика
        Epic epic1 = new Epic("Epic 1", "Description of Epic 1", 0, TaskStatus.NEW);
        int epic1Id = taskManager.addNewEpic(epic1);
        System.out.println("Added epic: " + epic1);

        // Создание и добавление подзадач к эпику
        Subtask subtask1 = new Subtask("Subtask 1", "Description of Subtask 1", 120, TaskStatus.NEW, epic1Id);
        int subtask1Id = taskManager.addNewSubtask(subtask1);
        System.out.println("Added subtask: " + subtask1);

        Subtask subtask2 = new Subtask("Subtask 2", "Description of Subtask 2", 90, TaskStatus.NEW, epic1Id);
        int subtask2Id = taskManager.addNewSubtask(subtask2);
        System.out.println("Added subtask: " + subtask2);

        // Получение и вывод задач
        Task retrievedTask1 = taskManager.getTask(task1Id);
        System.out.println("Retrieved task: " + retrievedTask1);

        Epic retrievedEpic1 = taskManager.getEpic(epic1Id);
        System.out.println("Retrieved epic: " + retrievedEpic1);

        Subtask retrievedSubtask1 = taskManager.getSubtask(subtask1Id);
        System.out.println("Retrieved subtask: " + retrievedSubtask1);

        Subtask retrievedSubtask2 = taskManager.getSubtask(subtask2Id);
        System.out.println("Retrieved subtask: " + retrievedSubtask2);

        // Обновление задач
        task1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateTask(task1);
        System.out.println("Updated task: " + taskManager.getTask(task1Id));

        subtask1.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask1);
        System.out.println("Updated subtask: " + taskManager.getSubtask(subtask1Id));
        System.out.println("Updated epic after subtask update: " + taskManager.getEpic(epic1Id));

        // Удаление задач
        taskManager.deleteTask(task2Id);
        System.out.println("Deleted task with ID: " + task2Id);

        taskManager.deleteSubtask(subtask2Id);
        System.out.println("Deleted subtask with ID: " + subtask2Id);
        System.out.println("Updated epic after subtask deletion: " + taskManager.getEpic(epic1Id));

        // Получение истории
        List<Task> history = taskManager.getHistory();
        System.out.println("History: " + history);
    }
}
