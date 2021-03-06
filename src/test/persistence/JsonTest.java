package persistence;

import model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Represent a test class for JsonTest class
// Citation: code obtained from JsonSerializationDemo
//           URL:https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonTest {
    protected void checkTask(String taskName, String state, Task task) {
        assertEquals(taskName, task.getTask());
        assertEquals(state, task.getState());
    }
}

