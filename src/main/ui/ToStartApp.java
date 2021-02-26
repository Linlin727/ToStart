package ui;

import model.Task;
import model.ToDoList;

import java.util.Scanner;

public class ToStartApp {
    private Task task;
    private Task statue;
    private Scanner input;
    private boolean update;

    private String string;
    private int index;

    public ToStartApp() {
        runToStart();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runToStart() {
        boolean keepGoing = true;
        String choice = null;

        Scanner input = new Scanner(System.in);
        ToDoList todoList = new ToDoList();

        while (keepGoing) {
            displayMenu();
//            System.out.println("--------Welcome to ToStart--------");
//            System.out.println("1 Add task");
//            System.out.println("2 Delete task");
//            System.out.println("3 Mark task");
//            System.out.println("4 View List");
//            System.out.println("5 Quit");
//            System.out.println("----------------------------------");

            System.out.println("Please enter your selection: ");
            choice = input.nextLine();
            if (choice.equals("1")) {
                doAddTask(todoList);
//                Task newTask = makeTask();
//                todoList.addTask(newTask);
            } else if (choice.equals("2")) {
                doDeleteTask(todoList, index);
//                System.out.println("Please enter Task you want to delete:");
//                String taskName = input.nextLine();
//                todoList.deleteTask(taskName);
//                if (todoList.deleteTask(taskName)) {
//                    System.out.println(" The statue fo this task is successfully updated");
//
//                } else {
//                    System.out.println("This task does not exist");
//                }

            } else if (choice.equals("3")) {
                doMarkTask(todoList);
//                Task taskWithNewStatue = updateStatue();
//                todoList.updateTaskStatue(taskWithNewStatue);
//                if (todoList.updateTaskStatue(taskWithNewStatue)) {
//                    System.out.println(" The statue fo this task is successfully updated");
//
//                } else {
//                    System.out.println("This task does not exist");
//                }

            } else if (choice.equals("4")) {
                doDisplayList(todoList, string);

            } else if (choice.equals("5")) {
                keepGoing = false;
            } else {
                System.out.println("Selection not valid");
            }
        }

        System.out.println("\nGoodbye!");
    }
//    private void init(){
//        Scanner input = new Scanner(System.in);
//        ToDoList todoList = new ToDoList();
//    }

    private void displayMenu() {
        System.out.println("--------Welcome to ToStart--------");
        System.out.println("1 Add task");
        System.out.println("2 Delete task");
        System.out.println("3 Mark task");
        System.out.println("4 View todo-list");
        System.out.println("5 Quit");
        System.out.println("----------------------------------");
    }

    private void doAddTask(ToDoList todoList) {
        Task newTask = makeTask();
        todoList.addTask(newTask);
    }

    private void doDeleteTask(ToDoList todoList, int index) {
        if (todoList.getSize() == 0) {
            return;
        } else {
//            todoList.displayToDoList();
            System.out.println("Please enter Task you want to delete:");
            String taskName = input.nextLine();
//            todoList.deleteTask(taskName);
            if (!todoList.deleteTask(taskName)) {
                System.out.println("This task does not exist");
            } else {
                System.out.println(" This task is successfully deleted");
            }
//            System.out.println(" This task is successfully deleted");
//            boolean a = todoList.deleteTask(taskName);
//            if (a == true) {
//                System.out.println(" This task is successfully deleted");
//
//            } else {
//                System.out.println("This task does not exist");
//            }
        }
    }

    private void doMarkTask(ToDoList todoList) {
        if (todoList.getSize() == 0) {
            return;
        } else {
            Task taskWithNewState = updateState();
            todoList.updateTaskState(taskWithNewState);
            if (todoList.updateTaskState(taskWithNewState)) {
                System.out.println(" The state of this task is successfully updated");

            } else {
                System.out.println("This task does not exist");
            }
        }
    }

    private void doDisplayList(ToDoList todoList, String s) {
        System.out.println(todoList.displayToDoList());

    }

    private Task makeTask() {
        input = new Scanner(System.in);
        System.out.println("Please enter Task:");
        String task = input.nextLine();
        System.out.println("Please choose State of this task, In-progress or Done:");
        String statue = input.nextLine();

        Task t = new Task(task, statue);
        return t;

    }

    private Task updateState() {
        input = new Scanner(System.in);
        System.out.println("Please enter the task you want to update:");
        String task = input.nextLine();
        System.out.println("Please choose a new state for this task");
        String state = input.nextLine();
        Task t = new Task(task, state);
        return t;
    }
}



