package model;

import exception.InvalidStateException;
import exception.InvalidTaskException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    private ToDoList testToDoList;
    private Task task;
    private String t;
    private String s;

    @BeforeEach
    void setUp() {
        testToDoList = new ToDoList();
        t = "aa";
        s = "bb";
        try {
            task = new Task(t, s);
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }

    }

    @Test
    void testConstructor() {
        assertFalse(testToDoList.contains(task));
        assertEquals(0, testToDoList.getSize());

    }

    @Test
    void testAddTask() {
        testToDoList.addTask(task);
        assertEquals("bb", task.getState());
        assertTrue(testToDoList.contains(task));
        assertEquals(1, testToDoList.getSize());

    }

    @Test
    void testDeleteTaskSuccess() {
        testToDoList.addTask(task);
        Task task2 = null;
        try {
            task2 = new Task("11 ","22");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        testToDoList.addTask(task2);
        assertTrue(testToDoList.deleteTask(task.getTask()));
        testToDoList.deleteTask(task.getTask());
        assertFalse(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertTrue(testToDoList.deleteTask(task2.getTask()));


    }

    @Test
    void testDeleteTaskInvalidTask() {
        testToDoList.addTask(task);
        Task task2 = null;
        try {
            task2 = new Task("11 ","22");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        testToDoList.addTask(task2);
        assertTrue(testToDoList.deleteTask(task.getTask()));
        testToDoList.deleteTask(task.getTask());
        assertFalse(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertFalse(testToDoList.deleteTask(task.getTask()));
        assertFalse(testToDoList.deleteTask("xx"));

    }

    @Test
    void TestDisplayToDoList() {
        testToDoList.addTask(task);
        Task task2 = null;
        try {
            task2 = new Task("cc ","dd");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        testToDoList.addTask(task2);
        assertEquals(testToDoList.displayToDoList(), "[task: aa state: bb, task: cc  state: dd]");
    }

    @Test
    void TestDisplayToDoListEmptyList() {
        assertEquals(testToDoList.displayToDoList(), "This list is empty");
    }

    @Test
    void TestUpdateTaskState() {
        testToDoList.addTask(task);
        Task task2 = null;
        Task task3 = null;
        try {
            task2 = new Task("cc ","dd");
            task3 = new Task("ee", "ff");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        testToDoList.addTask(task2);
        assertTrue(testToDoList.updateTaskState(task));
        assertTrue(testToDoList.updateTaskState(task2));
        assertFalse(testToDoList.updateTaskState(task3));


    }

    @Test
    void TestGetSize() {
        testToDoList.addTask(task);
        Task task2 = null;
        Task task3 = null;
        try {
            task2 = new Task("cc ","dd");
            task3 = new Task("ee", "ff");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        testToDoList.addTask(task2);
        assertEquals(2, testToDoList.getSize());
        testToDoList.addTask(task3);
        assertEquals(3, testToDoList.getSize());

    }

    @Test
    void TestContains() {
        testToDoList.addTask(task);
        assertTrue(testToDoList.contains(task));
        Task task2 = null;
        Task task3 = null;
        try {
            task2 = new Task("cc ","dd");
            task3 = new Task("ee", "ff");
        } catch (InvalidTaskException e) {
            fail("Should not throw InvalidTaskException");
        } catch (InvalidStateException e) {
            fail("Should not throw InvalidStateException");
        }
        assertFalse(testToDoList.contains(task2));
        testToDoList.addTask(task2);
        assertTrue(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertFalse(testToDoList.contains(task3));
        testToDoList.addTask(task3);
        assertTrue(testToDoList.contains(task3));

    }


}
