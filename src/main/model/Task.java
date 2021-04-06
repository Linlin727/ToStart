package model;

import exception.InvalidStateException;
import exception.InvalidTaskException;

// EFFECTS: Create a task.

public class Task {

    private String task;

    private String state;

    public Task(String task, String state) throws InvalidTaskException, InvalidStateException {
        checkTask(task);
        checkState(state);
        this.task = task;
        this.state = state;
    }

    // EFFECTS: Throw exception if task string contains punctuation.

    private void checkTask(String task) throws InvalidTaskException {

        String check = task;
        check = check.replaceAll("\\p{P}", "");
        if (task.length() != check.length()) {
            throw new InvalidTaskException("Task should not include punctuation");
        }
    }

    // EFFECTS: Throw exception if state string is longer than 30 characters.

    private void checkState(String state) throws InvalidStateException {

        if (state.length() > 30) {
            throw new InvalidStateException("State should be less than 30 characters");
        }
    }


    public String getTask() {
        return task;
    }


    public String getState() {
        return state;
    }


    // EFFECTS: change task to String.

    @Override
    public String toString() {
        return "task: " + task + " state: " + state;
    }


}
