import managers.FileBackedTaskManager;
import managers.TaskManager;
import models.Epic;
import models.Subtask;
import models.Task;
import models.TaskStatus;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            File file = File.createTempFile("tasks", ".csv");

            TaskManager taskManager = new FileBackedTaskManager(file);

            Task task1 = new Task("Task 1", "Description 1", 0, TaskStatus.NEW);
            int task1Id = taskManager.addNewTask(task1);

            Epic epic1 = new Epic("Epic 1", "Description 1", 0, TaskStatus.NEW);
            int epic1Id = taskManager.addNewEpic(epic1);

            Subtask subtask1 = new Subtask("Subtask 1", "Description 1", 0, TaskStatus.NEW, epic1Id);
            int subtask1Id = taskManager.addNewSubtask(subtask1);

            Task retrievedTask1 = taskManager.getTask(task1Id);
            System.out.println("Retrieved Task: " + retrievedTask1.getName());

            Epic retrievedEpic1 = taskManager.getEpic(epic1Id);
            System.out.println("Retrieved Epic: " + retrievedEpic1.getName());

            Subtask retrievedSubtask1 = taskManager.getSubtask(subtask1Id);
            System.out.println("Retrieved Subtask: " + retrievedSubtask1.getName());

            taskManager.updateTask(new Task("Updated Task 1", "Updated Description 1", 0, TaskStatus.IN_PROGRESS));

            taskManager.deleteTask(task1Id);
            taskManager.deleteEpic(epic1Id);

            System.out.println("\nLoading from file...");
            TaskManager loadedTaskManager = FileBackedTaskManager.loadFromFile(file);

            // Проверяем, что все задачи восстановлены корректно
            System.out.println("Loaded Tasks: " + loadedTaskManager.getTasks());
            System.out.println("Loaded Epics: " + loadedTaskManager.getEpics());
            System.out.println("Loaded Subtasks: " + loadedTaskManager.getSubtasks());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
