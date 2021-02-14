package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task testTask;
    @BeforeEach
    void setUp(){testTask = new Task("aa","bb"); }

    @Test
    void testConstructor(){
        assertEquals("aa",testTask.getTask());
        assertEquals("bb",testTask.getState());
    }

    @Test
    void testConstructorEmptyState(){
        Task testTask1 = new Task("aa", "");
        assertEquals("aa",testTask1.getTask());
        assertEquals("",testTask1.getState());
    }
    @Test
    void testGetState(){
        assertEquals("aa",testTask.getTask());
        assertEquals("bb",testTask.getState());
    }

    @Test
    void testToString(){
        assertTrue(testTask.toString().contains("task: aa state: bb"));
        Task testTask1 = new Task("aa", "");
        assertFalse(testTask1.toString().contains("task: aa state: bb"));
        assertTrue(testTask1.toString().contains("task: aa state: "));
    }

}
