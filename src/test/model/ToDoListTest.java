package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    private ToDoList testToDoList;
    private Task task;

    @BeforeEach
    void setUp(){
        testToDoList = new ToDoList();
        task = new Task("aa","bb");
    }

    @Test
    void testConstructor(){
        assertFalse(testToDoList.contains(task));
        assertEquals(0,testToDoList.getSize());

    }

    @Test
    void testAddTask(){
        testToDoList.addTask(task);
        assertEquals("bb",task.getState());
        assertTrue(testToDoList.contains(task));
        assertEquals(1,testToDoList.getSize());

    }

    @Test
    void testDeleteTaskSuccess(){
        testToDoList.addTask(task);
        Task task2 = new Task("11", "22");
        testToDoList.addTask(task2);
        assertTrue(testToDoList.deleteTask(task.getTask()));
        testToDoList.deleteTask(task.getTask());
        assertFalse(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertTrue(testToDoList.deleteTask(task2.getTask()));


    }
    @Test
    void testDeleteTaskInvalidTask(){
        testToDoList.addTask(task);
        Task task2 = new Task("11", "22");
        testToDoList.addTask(task2);
        assertTrue( testToDoList.deleteTask(task.getTask()));
        testToDoList.deleteTask(task.getTask());
        assertFalse(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertFalse( testToDoList.deleteTask(task.getTask()));
        assertFalse(testToDoList.deleteTask("xx"));

    }
//    @Test
//    void TestDisplayToDoList(){
//        testToDoList.addTask(task);
//        Task task2 = new Task("cc", "dd");
//        testToDoList.addTask(task2);
//        assertEquals(testToDoList.displayToDoList(),"[task: aa state: bb, task: cc state: dd]");
//    }
//    @Test
//    void TestDisplayToDoListEmptyList(){
//        assertEquals(testToDoList.displayToDoList(),"This list is empty");
//    }

    @Test
    void TestUpdateTaskState(){
        testToDoList.addTask(task);
        Task task2 = new Task("cc", "dd");
        Task task3 = new Task("ee", "ff");
        testToDoList.addTask(task2);
        assertTrue(testToDoList.updateTaskState(task));
        assertTrue(testToDoList.updateTaskState(task2));
        assertFalse(testToDoList.updateTaskState(task3));


    }

    @Test
    void TestGetSize(){
        testToDoList.addTask(task);
        Task task2 = new Task("cc", "dd");
        Task task3 = new Task("ee", "ff");
        testToDoList.addTask(task2);
        assertEquals(2,testToDoList.getSize());
        testToDoList.addTask(task3);
        assertEquals(3,testToDoList.getSize());

    }

    @Test
    void TestContains(){
        testToDoList.addTask(task);
        assertTrue(testToDoList.contains(task));
        Task task2 = new Task("cc", "dd");
        assertFalse(testToDoList.contains(task2));
        Task task3 = new Task("ee", "ff");
        testToDoList.addTask(task2);
        assertTrue(testToDoList.contains(task));
        assertTrue(testToDoList.contains(task2));
        assertFalse(testToDoList.contains(task3));
        testToDoList.addTask(task3);
        assertTrue(testToDoList.contains(task3));

    }





}
