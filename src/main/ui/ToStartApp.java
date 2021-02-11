package ui;

import model.Task;
import model.ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToStartApp {
    private Task task;
    private Task statue;
    private Scanner input;
    private boolean update;

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

                Task newTask = makeTask();
                todoList.addTask(newTask);
            } else if (choice.equals("2")) {
                System.out.println("Please enter Task you want to delete:");
                String taskName = input.nextLine();
                todoList.deleteTask(taskName);
                if (todoList.deleteTask(taskName)) {
                    System.out.println(" The statue fo this task is successfully updated");

                } else {
                    System.out.println("This task does not exist");
                }

            } else if (choice.equals("3")) {
                Task taskWithNewStatue = updateStatue();
                todoList.updateTaskStatue(taskWithNewStatue);
                if (todoList.updateTaskStatue(taskWithNewStatue)) {
                    System.out.println(" The statue fo this task is successfully updated");

                } else {
                    System.out.println("This task does not exist");
                }

            } else if (choice.equals("4")) {
                todoList.displayToDoList();

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

//    private void doAddTask() {
//        Task newTask = makeTask();
//        todoList.addTask(newTask);
//    }

    private Task makeTask() {
        input = new Scanner(System.in);
        System.out.println("Please enter Task:");
        String task = input.nextLine();
        System.out.println("Please choose Statue of this task, In-progress or Have not started:");
        String statue = input.nextLine();

        Task t = new Task(task, statue);
        return t;

    }

    private Task updateStatue() {
        input = new Scanner(System.in);
        System.out.println("Please enter the task you want to update:");
        String task = input.nextLine();
        System.out.println("Please choose a new statue for this task");
        String statue = input.nextLine();
        Task t = new Task(task, statue);
        return t;
    }
}



