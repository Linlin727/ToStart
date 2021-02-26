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


    public boolean deleteTask(String task) {
//        if (todoList.size() == 0) {
//            return false;
//        }
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

    public String displayToDoList() {
        String s;
        if (todoList.size() == 0) {
            s = "This list is empty";
        } else {
            s = todoList.toString();
//            for (Task t : todoList) {
//                s = t.toString();
//            }
        }
//                for (int i = 0; i < todoList.size(); i++) {
//                    Task t = todoList.get(i);
//                    s = t.getTask() + t.getState();
//            }
//                System.out.println(t.getTask() + "\t\t\t" + t.getStatue());


        return s;
    }

    public boolean updateTaskState(Task t) {
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

    public int getSize() {
        int size;
        size = todoList.size();
        return size;
    }

    public boolean contains(Task t) {
        return todoList.contains(t);
    }

}
