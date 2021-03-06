package persistence;

import model.ToDoList;
import model.Task;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public ToDoList read() throws IOException {
        String jsonData = readFile(source);

        JSONArray jsonArray = new JSONArray(jsonData);
        return parseToDoList(jsonArray);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private ToDoList parseToDoList(JSONArray jsonArray) {
//        String task = jsonObject.getString("task");
        ToDoList todoList = new ToDoList();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            String task = json.getString("task");
            String state = json.getString("state");
            todoList.addTask(new Task(task,state));
        }
        return todoList;
    }
//
//    // MODIFIES: wr
//    // EFFECTS: parses thingies from JSON object and adds them to workroom
//    private void addToDoList(ToDoList todoList, JSONObject jsonObject) {
//        JSONArray jsonArray = jsonObject.getJSONArray("todoList");
//        for (Object json : jsonArray) {
//            JSONObject nextTask = (JSONObject) json;
//            addTask(todoList, nextTask);
//        }
//    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom

}
