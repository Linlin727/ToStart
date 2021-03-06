package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList implements Writable {
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

    public List<Task> getToDoList() {
        return Collections.unmodifiableList(todoList);
    }

//    public String displayToDoList() {
//        String s;
//        if (todoList.size() == 0) {
//            s = "This list is empty";
//        } else {
//            s = todoList.toString();
//            for (Task t : todoList) {
//                s = t.toString();
//            }
//        }
//                for (int i = 0; i < todoList.size(); i++) {
//                    Task t = todoList.get(i);
//                    s = t.getTask() + t.getState();
//            }
//                System.out.println(t.getTask() + "\t\t\t" + t.getStatue());

//
//        return s;
//    }

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

    public Task getTask(int i) {
        return todoList.get(i);
    }

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
    public JSONArray toJson() {
//        JSONArray jsonArray = new JSONArray();
//
//        for (Task t : todoList) {
//            jsonArray.put(t.toJson());
//        }
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


