package persistence;

import model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTask(String taskName, String state, Task task) {
        assertEquals(taskName, task.getTask());
        assertEquals(state, task.getState());
    }
}

