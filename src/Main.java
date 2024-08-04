import managers.TaskManager;
import managers.Managers;
import models.Epic;
import models.Subtask;
import models.Task;
import models.TaskStatus;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();

        // Создаем несколько задач разного типа
        Task task1 = new Task("Task 1", "Description 1", 0, TaskStatus.NEW);
        Task task2 = new Task("Task 2", "Description 2", 0, TaskStatus.NEW);
        int taskId1 = taskManager.addNewTask(task1);
        int taskId2 = taskManager.addNewTask(task2);

        Epic epic1 = new Epic("Epic 1", "Epic Description 1", 0, TaskStatus.NEW);
        int epicId1 = taskManager.addNewEpic(epic1);

        Subtask subtask1 = new Subtask("Subtask 1", "Subtask Description 1", 0, TaskStatus.NEW, epicId1);
        Subtask subtask2 = new Subtask("Subtask 2", "Subtask Description 2", 0, TaskStatus.NEW, epicId1);
        taskManager.addNewSubtask(subtask1);
        taskManager.addNewSubtask(subtask2);

        // Вызываем методы интерфейса TaskManager и печатаем историю просмотров
        System.out.println("После добавления задач:");
        printAllTasks(taskManager);

        // Получаем задачи и печатаем историю после каждого вызова
        taskManager.getTask(taskId1);
        System.out.println("После просмотра Task 1:");
        printAllTasks(taskManager);

        taskManager.getTask(taskId2);
        System.out.println("После просмотра Task 2:");
        printAllTasks(taskManager);

        taskManager.getEpic(epicId1);
        System.out.println("После просмотра Epic 1:");
        printAllTasks(taskManager);

        taskManager.getSubtask(subtask1.getId());
        System.out.println("После просмотра Subtask 1:");
        printAllTasks(taskManager);

        taskManager.getSubtask(subtask2.getId());
        System.out.println("После просмотра Subtask 2:");
        printAllTasks(taskManager);
    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Epic epic : manager.getEpics()) {
            System.out.println(epic);
            for (Subtask subtask : manager.getEpicSubtasks(epic.getId())) {
                System.out.println("--> " + subtask);
            }
        }
        System.out.println("Подзадачи:");
        for (Subtask subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }
        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}
