package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a todoList as list of tasks
public class ToDoList implements Writable {
    private ArrayList<Task> todoList;

    public ToDoList() {
        todoList = new ArrayList<>();
    }

    // MODIFIES: todoList
    // EFFECTS: add t to todoList

    public void addTask(Task t) {
        todoList.add(t);
    }


    // MODIFIES: todoList
    // EFFECTS: if there exist a task with task name "task",delete this task from todoList and returns true
    // otherwise returns false

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
            return false;
        } else {
            todoList.remove(index);
            return true;
        }

    }


    // EFFECTS:returns a String which represents the todolist if the todoList is not empty
    //returns the String "This list is empty" is the todoList is empty

    public String displayToDoList() {
        String s;
        if (todoList.size() == 0) {
            s = "This list is empty";
        } else {
            s = todoList.toString();
        }
        return s;
    }

    // MODIFIES: todoList
    // EFFECTS: change the task with the same name of t to t which has a new state
    // returns true if the state of task t has been updated, false otherwise
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
            return false;
        } else {
            todoList.set(index, t);
            return true;
        }
    }

    public int getSize() {
        int size;
        size = todoList.size();
        return size;
    }

    public Task getTask(int i) {
        return todoList.get(i);
    }

    // EFFECTS: returns true if todoList contains t, false otherwise
    public boolean contains(Task t) {
        return todoList.contains(t);
    }
//    @Override
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//        json.put("todoList", toJsonArray());
//        return json;
//    }


    // EFFECTS: returns tasks in this todoList as a JSON array
    @Override
    public JSONArray toJson() {
        ArrayList<JSONObject> jasonObjects = new ArrayList<>();
        for (Task t : todoList) {
            JSONObject jasonObject = new JSONObject();
            jasonObject.put("task", t.getTask());
            jasonObject.put("state", t.getState());
            jasonObjects.add(jasonObject);
        }
        JSONArray jasonArray = new JSONArray(jasonObjects);

        return jasonArray;
    }

}


