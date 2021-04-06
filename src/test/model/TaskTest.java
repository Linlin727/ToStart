package model;

import exception.InvalidStateException;
import exception.InvalidTaskException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private Task testTask;
    private String task;
    private String state;


    @Test
    void testConstructorTaskIncludesPunctuation(){
        task = "a!";
        state = "a";
        try{
            new Task(task,state);
            fail("Should throw InvalidTaskException");
        }catch(InvalidTaskException e){
            System.out.println(e.getMessage());
        }catch(InvalidStateException e){
            fail("Should not throw InvalidStateException");
        }
    }

    @Test
    void testConstructorStateTooLong(){
        task = "aa";
        state = "tootootootootootootootootootoolong";
        try{
            new Task(task,state);
            fail("Should throw InvalidStateException");
        }catch(InvalidTaskException e){
            fail("Should not throw InvalidTaskException");
        }catch(InvalidStateException e){
            System.out.println(e.getMessage());
        }
    }



    @Test
    void testConstructorValidInput(){
        task = "aa";
        state = "bb";
        try{
            testTask = new Task(task,state);
        }catch(InvalidTaskException e){
            fail("Should not throw InvalidTaskException");
        }catch(InvalidStateException e){
            fail("Should not throw InvalidStateException");
        }
        assertEquals("aa",testTask.getTask());
        assertEquals("bb",testTask.getState());
        assertTrue(testTask.toString().contains("task: aa state: bb"));
    }

    @Test
    void testConstructorValidInputEmptyState(){
        task = "aa";
        state = "";
        try{
            testTask = new Task(task,state);
        }catch(InvalidTaskException e){
            fail("Should not throw InvalidTaskException");
        }catch(InvalidStateException e){
            fail("Should not throw InvalidStateException");
        }
        assertEquals("aa",testTask.getTask());
        assertEquals("",testTask.getState());
        assertFalse(testTask.toString().contains("task: aa state: bb"));
        assertTrue(testTask.toString().contains("task: aa state: "));
    }




}
