package persistence;

import model.Task;
import model.ToDoList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            ToDoList todoList = new ToDoList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyToDoList() {
        try {
            ToDoList todoList = new ToDoList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyToDoList.json");
            writer.open();
            writer.write(todoList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyToDoList.json");
            todoList = reader.read();
            assertEquals(0, todoList.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralToDoList() {
        try {
            ToDoList todoList = new ToDoList();
            todoList.addTask(new Task("aa", "aa"));
            todoList.addTask(new Task("bb", "bb"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralToDoList.json");
            writer.open();
            writer.write(todoList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralToDoList.json");
            todoList = reader.read();
//            List<Thingy> thingies = wr.getThingies();
            assertEquals(2, todoList.getSize());
            checkTask("aa", "aa", todoList.getTask(0));
            checkTask("bb", "bb", todoList.getTask(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}