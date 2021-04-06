package persistence;

import exception.InvalidUserInputException;
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

// Represents a reader that reads todoList from JSON data stored in file.
// Citation: code obtained from JsonSerializationDemo
//           URL:https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads todoList from file and returns todoList;
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

    // EFFECTS: parses todoList from JSON array and parses each task from JSON object and adds them to
    //todoList, finally returns todoList
    private ToDoList parseToDoList(JSONArray jsonArray) {
        ToDoList todoList = new ToDoList();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            String task = json.getString("task");
            String state = json.getString("state");
            try {
                todoList.addTask(new Task(task, state));
            } catch (InvalidUserInputException exception) {
                System.out.println("wrong!!");
            }
        }
        return todoList;
    }


}
