package model;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> todoList;

    public ToDoList() {
        todoList = new ArrayList<>();
    }

    public void addTask(Task t) {
        todoList.add(t);
    }

    public void deleteTask(int index) {
        todoList.remove(index);
    }

    public boolean deleteTask(String task) {
        int index = -7;
        for (int i = 0; i < todoList.size(); i++) {
            Task t = todoList.get(i);
            if (t.getTask().equals(task)) {
                index = i;
                break;
            }
        }

        if (index == -7) {
//            System.out.println("This task does not exist");
            return false;
        } else {
            todoList.remove(index);
//            System.out.println(" This task is successfully deleted");
            return true;
        }

    }

    public void displayToDoList() {
        if (todoList.size() == 0) {
            System.out.println("ToStart-list is empty, please add task");
        } else {
            System.out.println("Task\t\tStatue");
            for (int i = 0; i < todoList.size(); i++) {
                Task t = todoList.get(i);
                System.out.println(t.getTask() + "\t\t\t" + t.getStatue());
            }
        }
    }

    public boolean updateTaskStatue(Task t) {
        int index = -7;
        for (int i = 0; i < todoList.size(); i++) {
            Task task = todoList.get(i);
            if (task.getTask().equals(t.getTask())) {
                index = i;
                break;
            }
        }
        if (index == -7) {
//            System.out.println("This task does not exist");
            return false;
        } else {
            todoList.set(index, t);
//            System.out.println(" The statue fo this task is successfully updated");
            return true;
        }
    }

}
