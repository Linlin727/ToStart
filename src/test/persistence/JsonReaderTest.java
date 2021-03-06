package persistence;

import model.Task;
import model.ToDoList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Represent a test class for JsonReader class
// Citation: code obtained from JsonSerializationDemo
//           URL:https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ToDoList todoList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyToDoList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyToDoList.json");
        try {
            ToDoList todoList = reader.read();
            assertEquals(0, todoList.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralToDoList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralToDoList.json");
        try {
            ToDoList todoList = reader.read();
//            List<Task> todos = wr.getThingies();
            assertEquals(2, todoList.getSize());
            checkTask("aa", "aa", todoList.getTask(0));
            checkTask("bb", "bb", todoList.getTask(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
