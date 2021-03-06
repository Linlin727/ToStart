package ui;

import model.Task;
import model.ToDoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ToStartApp {

    private String state;
    private Scanner input;
    private boolean update;
    private String string;
    private int index;
    private static final String JSON_STORE = "./data/todoList.json";

    private ToDoList todoList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public ToStartApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        todoList = new ToDoList();
        runToStart();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runToStart() {
        boolean keepGoing = true;
        String choice = null;
        Scanner input = new Scanner(System.in);
        while (keepGoing) {
            displayMenu();

            choice = input.nextLine();
            if (choice.equals("7")) {
                keepGoing = false;
            } else {
                processChoice(choice);
            }
        }
        System.out.println("\nGoodbye!");
    }

    private void displayMenu() {
        System.out.println("--------Welcome to ToStart--------");
        System.out.println("1 Add task");
        System.out.println("2 Delete task");
        System.out.println("3 Mark task");
        System.out.println("4 View todo-list");
        System.out.println("5 Save todolist to file");
        System.out.println("6 Load todolist to file");
        System.out.println("7 Quit");
        System.out.println("----------------------------------");
        System.out.println("Please enter your selection: ");
    }

    private void processChoice(String choice) {
        if (choice.equals("1")) {
            doAddTask();

        } else if (choice.equals("2")) {
            doDeleteTask(index);


        } else if (choice.equals("3")) {
            doMarkTask();


        } else if (choice.equals("4")) {
            doDisplayList();

        } else if (choice.equals("5")) {
            saveToStartList();

        } else if (choice.equals("6")) {
            loadToStartList();

        } else {
            System.out.println("Selection not valid");
        }
    }


    private void doAddTask() {
        Task newTask = makeTask();
        todoList.addTask(newTask);
    }

    private void doDeleteTask(int index) {
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

    private void doMarkTask() {
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

    private void doDisplayList() {
//        System.out.println(todoList.displayToDoList());
        List<Task> todos = todoList.getToDoList();
        for (Task t : todos) {
            System.out.println(t);
        }

    }

    private Task makeTask() {
        input = new Scanner(System.in);
        System.out.println("Please enter Task:");
        String task = input.nextLine();
        System.out.println("Please choose State of this task, In-progress or Done:");
        String state = input.nextLine();

        Task t = new Task(task, state);
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

    // EFFECTS: saves the ToStartList to file
    private void saveToStartList() {
        try {
//            PrintWriter writer = new PrintWriter(JSON_STORE,"UTF-8");
            jsonWriter.open();
            jsonWriter.write(todoList);
            jsonWriter.close();
            System.out.println("Saved " + " ToStartList to " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads ToStartList from file
    private void loadToStartList() {
        try {
            todoList = jsonReader.read();
            System.out.println(todoList);
            System.out.println("Loaded " + "ToStartList from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}



